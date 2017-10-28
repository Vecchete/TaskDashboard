package com.voxus.taskdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voxus.taskdashboard.model.*;
import com.voxus.taskdashboard.dao.*;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
     
    @Autowired
    UserDao dao;
     
    public User findById(Integer id) {
        return dao.findById(id);
    }
    
    public User findByUsername (String Username) {
        return dao.findByUsername(Username);
    }
    
    public User findByEmail (String Email) {
        return dao.findByEmail(Email);
    }
  
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
        
    public void save(User user) {
    	dao.save(user);
    }
    
    public boolean existUser (String email) {
    	User user_search = findByEmail(email);
    	if (user_search == null) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
}