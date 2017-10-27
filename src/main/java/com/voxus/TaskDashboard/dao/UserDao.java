package com.voxus.TaskDashboard.dao;

import java.util.List;
import com.voxus.TaskDashboard.model.User;

public interface UserDao {
	User findById(Integer id);    
    User findByUsername(String Username); 
    User findByEmail(String Email); 
    void save(User user);     
    List<User> findAllUsers();
}
