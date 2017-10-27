package com.voxus.TaskDashboard.service;

import java.util.List;
import com.voxus.TaskDashboard.model.User;

public interface UserService {
	User findById(Integer id);    
    User findByUsername(String Username);  
    User findByEmail(String Email); 
    void save(User user);     
    List<User> findAllUsers();
    boolean existUser(String email);
}
