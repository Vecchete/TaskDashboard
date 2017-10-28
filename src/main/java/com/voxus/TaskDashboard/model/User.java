package com.voxus.taskdashboard.model;
 
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USERS")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer UserId;
	
	@NotEmpty 
	@Column(name="Username", nullable=false)
    private String Username;
	
	@NotEmpty
    @Column(name="Email", nullable=false)
    private String Email;

//	@JoinTable(name = "USER_TASK", 
//    joinColumns = { @JoinColumn(name = "UserId") }, 
//    inverseJoinColumns = { @JoinColumn(name = "TaskId") })
//	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	public Integer getId() {
		return UserId;
	}
	
	public void setId(Integer id) {
		this.UserId = id;
	}
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String Username) {
		this.Username = Username;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (UserId == null) {
            if (other.UserId != null) {
            	return false;
            }else {
            	return true;
            }
        } else if (!UserId.equals(other.UserId)) {
        	return false;
        }else {
        	return true;
        } 
    }
	
//	public User() {
//		this.UserId = null;
//		this.Username = null;
//		this.Email = null;
//	}

}
