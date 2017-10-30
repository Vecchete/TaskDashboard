package com.voxus.taskdashboard.controller;

import java.util.*;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
 
import com.voxus.taskdashboard.model.*;
import com.voxus.taskdashboard.service.*;
import com.voxus.taskdashboard.controller.*;
 
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	private Integer IdUserCounter = 0;
	private Integer IdTaskCounter = 0;
	private Integer IdUser = 1;
	
    @Autowired
    UserService userService;
     
    @Autowired
    TaskService taskService;
     
     
    @Autowired
    MessageSource messageSource;
    
       
    /**
     * This method will list all tasks.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listTasks(ModelMap model) {
        List<Task> tasks = taskService.findAllActiveTasksbypriority();
        Iterator<Task> it = tasks.iterator();
        User user;
        Task task;
        List<TaskUser> pairs = new ArrayList<TaskUser>();
        while(it.hasNext()) {
        		task = (Task)it.next();
        		user = userService.findById(task.getSubmitUserID());
        		TaskUser pair = new TaskUser(task,user.getUsername());
        		pairs.add(pair);
        	}
        model.addAttribute("pairs", pairs);
        return "taskslist";
    }
 
    /**
     * This method will provide the medium to add a new task.
     */
    @RequestMapping(value = { "/newtask" }, method = RequestMethod.GET)
    public String newTask(ModelMap model) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /**
     * This method will be called on form submission, handling POST request for
     * saving task in database. It also validates the user input
     */
    @RequestMapping(value = { "/newtask" }, method = RequestMethod.POST)
    public String saveTask(@Valid Task task, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
        taskService.create(task.getTaskName(), task.getDescription(), task.getPriority(), this.IdUser);
        task = taskService.findById(IdTaskCounter);
        IdTaskCounter++;
        model.addAttribute("success", "Task " + task.getTaskName() + " registered successfully");
        //return "success";
        return "registrationsuccess";
    }
 
 
    /**
     * This method will provide the medium to update an existing task.
     */
    @RequestMapping(value = { "/edit-task-{Id}" }, method = RequestMethod.GET)
    public String editTask(@PathVariable Integer Id, ModelMap model) {
        Task task = taskService.findById(Id);
        model.addAttribute("task", task);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /**
     * This method will be called on form submission, handling POST request for
     * updating task in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-task-{Id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid Task task, BindingResult result,
            ModelMap model) {    	
        if (result.hasErrors()) {
            return "registration";
        }
        if (!task.getSubmitUserID().equals(IdUser)) {
        	FieldError updateIDError = new FieldError("task","IdUser",messageSource.getMessage("non.permission.ID", new String[]{Integer.toString(task.getId())}, Locale.getDefault()));
        	result.addError(updateIDError);
        	return "registration";
        }else {
        	taskService.edit(task.getId(), task.getTaskName(), task.getDescription(), task.getPriority());
        	model.addAttribute("success", "Task " + task.getTaskName() + " updated successfully");
            return "registrationsuccess";
        }
    }
 
     
    /**
     * This method will delete an task by it's ID value.
     */
    @RequestMapping(value = { "/delete-task-{Id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer Id,BindingResult result,ModelMap model) {
    	Task task = taskService.findById(Id);
    	if (!task.getSubmitUserID().equals(IdUser)) {
        	FieldError updateIDError = new FieldError("task","IdUser",messageSource.getMessage("non.permission.ID", new String[]{Integer.toString(task.getId())}, Locale.getDefault()));
        	result.addError(updateIDError);
        	return "redirect:/list";
        }else {
        	taskService.delete(Id);
            return "redirect:/list";
        }
    }     
    
    /**
     * This method will provide the login.
     */
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String loginSuccesful(@PathVariable String Username, @PathVariable String email, ModelMap model) {
        User user = new User();
        if (userService.existUser(email)==false) {
        	user.setId(IdUserCounter);
        	IdUserCounter++;
        	user.setUsername(Username);
        	user.setEmail(email);
        	userService.save(user);
        }else {
        	user = userService.findByEmail(email);
        }
        this.IdUser = user.getId();
        model.addAttribute("user", user);
        model.addAttribute("logout", false);
        return "loginSuccess";
    }
    
    /**
     * This method will provide the medium to logout.
     */
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String logoutSuccesful(ModelMap model) {
        User user = userService.findById(IdUser);
        this.IdUser = null;
        model.addAttribute("user", user);
        model.addAttribute("logout", true);
        return "logoutSuccess";
    }
 
}