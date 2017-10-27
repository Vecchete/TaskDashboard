package com.voxus.taskdashboard.service;

import java.util.List;
import com.voxus.taskdashboard.model.User;

public interface UserService {
	User findById(Integer id);    
    User findByUsername(String Username);  
    User findByEmail(String Email); 
    void save(User user);     
    List<User> findAllUsers();
    boolean existUser(String email);
}
