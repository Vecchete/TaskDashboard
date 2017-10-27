package com.voxus.taskdashboard.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository; 

import com.voxus.taskdashboard.model.Task;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task>implements TaskDao{
 
    public Task findById(Integer id) {
        return getByKey(id);
    }
      
    @SuppressWarnings("unchecked")
    public List<Task> findAllTasks(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("TaskId"));
        return (List<Task>)crit.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> findTaskbySubmitId(Integer Id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("SubmitUserID", Id));
        crit.addOrder(Order.asc("TaskId"));
        return (List<Task>)crit.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> findTaskbyDoneId(Integer Id){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("DoneUserID", Id));
        crit.addOrder(Order.asc("TaskId"));
        return (List<Task>)crit.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> findAllActiveTasksbydate(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("Status", 1));
        crit.addOrder(Order.asc("TaskId"));
        return (List<Task>)crit.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> findAllActiveTasksbypriority(){
    	List<Task> newList = new ArrayList<Task>();
    	List<Task> priority_five = new ArrayList<Task>();
    	List<Task> priority_four = new ArrayList<Task>();
    	List<Task> priority_three = new ArrayList<Task>();
    	List<Task> priority_two = new ArrayList<Task>();
    	List<Task> priority_one = new ArrayList<Task>();
    	Criteria crit5 = createEntityCriteria();
    	Criteria crit4 = createEntityCriteria();
    	Criteria crit3 = createEntityCriteria();
    	Criteria crit2 = createEntityCriteria();
    	Criteria crit1 = createEntityCriteria();
    	crit5.add(Restrictions.eq("Status", 1));
    	crit5.add(Restrictions.eq("Priority", 5));
    	crit5.addOrder(Order.asc("TaskId"));
    	crit4.add(Restrictions.eq("Status", 1));
    	crit4.add(Restrictions.eq("Priority", 4));
    	crit4.addOrder(Order.asc("TaskId"));
    	crit3.add(Restrictions.eq("Status", 1));
    	crit3.add(Restrictions.eq("Priority", 3));
    	crit3.addOrder(Order.asc("TaskId"));
    	crit2.add(Restrictions.eq("Status", 1));
    	crit2.add(Restrictions.eq("Priority", 2));
    	crit2.addOrder(Order.asc("TaskId"));
    	crit1.add(Restrictions.eq("Status", 1));
    	crit1.add(Restrictions.eq("Priority", 1));
    	crit1.addOrder(Order.asc("TaskId"));
    	priority_five = (List<Task>)crit5.list();
    	priority_four = (List<Task>)crit4.list();
    	priority_three = (List<Task>)crit3.list();
    	priority_two = (List<Task>)crit2.list();
    	priority_one = (List<Task>)crit1.list();
    	newList.addAll(priority_five);
    	newList.addAll(priority_four);
    	newList.addAll(priority_three);
    	newList.addAll(priority_two);
    	newList.addAll(priority_one);
    	return newList;
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> findAllDoneTasks(){
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("Status", 0));
        crit.addOrder(Order.asc("TaskId"));
        return (List<Task>)crit.list();
    }
    
    public void save(Task task) {
        persist(task);
    }
    
    public void delete(Integer id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("TaskId", id));
        Task task = (Task)crit.uniqueResult();
        delete(task);
    }
     
}