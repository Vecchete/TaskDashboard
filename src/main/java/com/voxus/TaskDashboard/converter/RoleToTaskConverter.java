package com.voxus.TaskDashboard.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
 
import com.voxus.TaskDashboard.model.*;
import com.voxus.TaskDashboard.service.*; 
/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToTaskConverter implements Converter<Object, Task>{
 
    @Autowired
    TaskService taskService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Task convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Task profile= taskService.findById(id);
        System.out.println("Profile : "+profile);
        return profile;
    }
     
}