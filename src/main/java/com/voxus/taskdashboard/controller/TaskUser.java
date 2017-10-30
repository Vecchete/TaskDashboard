package com.voxus.taskdashboard.controller;

import com.voxus.taskdashboard.model.*;
import java.util.*;

public class TaskUser {
	Task task;
	String nameUser;
	
	public TaskUser(Task task, String nameUser) {
		this.task = task;
		this.nameUser = nameUser;
	}
	
	public String getName(){
		return task.getTaskName();
	}
	
	public Integer getPriority(){
		return task.getPriority();
	}
	
	public Integer getId(){
		return task.getId();
	}
	
	public String getUsername(){
		return nameUser;
	}
}
