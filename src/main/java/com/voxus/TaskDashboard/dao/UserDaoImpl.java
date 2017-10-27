package com.voxus.TaskDashboard.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.voxus.TaskDashboard.model.User;
 
  
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    public User findById (Integer id) {
        User user = getByKey(id);
        return user;
    }
 
    public User findByUsername(String username) {
        System.out.println("Username : "+username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("Username", username));
        User user = (User)crit.uniqueResult();
        return user;
    }
    
    public User findByEmail(String email) {
        System.out.println("Email : "+email);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("Email", email));
        User user = (User)crit.uniqueResult();
        return user;
    }
    
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("Username"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
         
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }
 
    public void save(User user) {
        persist(user);
    }
  
}