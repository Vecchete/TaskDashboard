package com.voxus.taskdashboard.dao;

import java.util.List;
import com.voxus.taskdashboard.model.Task;


public interface TaskDao {
	Task findById (Integer Id);
	void save(Task task);
	void delete(Integer id);
	List<Task> findAllTasks();
	List<Task> findTaskbySubmitId (Integer id);
	List<Task> findTaskbyDoneId (Integer id);
	List<Task> findAllActiveTasksbydate();
	List<Task> findAllActiveTasksbypriority();
	List<Task> findAllDoneTasks();
}
