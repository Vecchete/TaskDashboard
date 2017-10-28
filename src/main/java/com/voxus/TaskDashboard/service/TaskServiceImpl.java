package com.voxus.taskdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voxus.taskdashboard.model.*;
import com.voxus.taskdashboard.dao.*;


@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{
     
    @Autowired
    TaskDao dao;
     
    public Task findById(Integer id) {
        return dao.findById(id);
    }
  
    public List<Task> findAllTasks() {
        return dao.findAllTasks();
    }
    
    public List<Task> findTaskbySubmitId (Integer id) {
        return dao.findTaskbySubmitId(id);
    }
    
    public List<Task> findTaskbyDoneId (Integer id) {
        return dao.findTaskbyDoneId(id);
    }
    
    public List<Task> findAllActiveTasksbydate() {
        return dao.findAllActiveTasksbydate();
    }
    
    public List<Task> findAllActiveTasksbypriority() {
        return dao.findAllActiveTasksbypriority();
    }
    
    public List<Task> findAllDoneTasks() {
        return dao.findAllDoneTasks();
    }
    
    public void save(Task task) {
    	dao.save(task);
    }
    
    public void create (String Name, String Description, Integer Priority, Integer SubmitUserID) {
    	Task task = new Task();
    	task.setName(Name);
    	task.setDesc(Description);
    	task.setPriority(Priority);
    	task.setSubmitID(SubmitUserID);
    	task.setDoneID(0);
    	task.setStatus(1);
    	save(task);
    }
    
    public boolean done (Integer TaskId, Integer DoneUserId) {
    	Task task = dao.findById(TaskId);
    	if (task!=null) {
    		task.setDoneID(DoneUserId);
        	save(task);
        	return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean edit(Integer TaskId, String Name, String Description, Integer Priority) {
    	Task task = dao.findById(TaskId);
    	if (task!=null) {
    		task.setName(Name);
        	task.setDesc(Description);
        	task.setPriority(Priority);
    		save(task);
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public void delete(Integer Id) {
    	dao.delete(Id);
    }
    
}