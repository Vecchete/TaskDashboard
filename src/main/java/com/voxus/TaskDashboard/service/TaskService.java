package com.voxus.taskdashboard.service;

import java.util.List;

import com.voxus.taskdashboard.model.Task;
 
public interface TaskService {

	Task findById (Integer Id);
	List<Task> findAllTasks();
	List<Task> findTaskbySubmitId (Integer id);
	List<Task> findTaskbyDoneId (Integer id);
	List<Task> findAllActiveTasksbydate();
	List<Task> findAllActiveTasksbypriority();
	List<Task> findAllDoneTasks();
	void save(Task task);
	void create(String Name, String Description, Integer Priority, Integer SubmitUserID);
	boolean done(Integer TaskId, Integer DoneUserId);
	boolean edit(Integer TaskId, String Name, String Description, Integer Priority);
	void delete(Integer TaskId);
}