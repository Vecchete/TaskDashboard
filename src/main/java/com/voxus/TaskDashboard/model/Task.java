package com.voxus.taskdashboard.model;
import java.util.*;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TASK")
public class Task {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer TaskId;
	
	@NotEmpty 
	@Column(name="TaskName", nullable=false)
    private String TaskName;
	
	@NotEmpty 
	@Column(name="Description", nullable=false)
    private String Description;
	
	@NotEmpty 
	@Column(name="Priority", nullable=false)
    private Integer Priority;
	
	@NotEmpty 
	@Column(name="SubmitUserID", nullable=false)
    private Integer SubmitUserID;
	
	@NotEmpty 
	@Column(name="DoneUserID", nullable=true)
    private Integer DoneUserID;
	
	@NotEmpty 
	@Column(name="Status", nullable=false)
    private Integer Status;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@Column(name="Files", nullable=true)
//	private List<Integer> Files = new ArrayList<>();
	
//	@JoinTable(name = "USER_TASK", 
//  joinColumns = { @JoinColumn(name = "SubmitUserId") }, 
//  inverseJoinColumns = { @JoinColumn(name = "TaskId") })
//	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	public Integer getId() {
		return TaskId;
	}
	
	public void setId(Integer Id) {
		this.TaskId = Id;
	}
	
	public String getName() {
		return TaskName;
	}
	
	public void setName(String Name) {
		this.TaskName = Name;
	}
	
	public String getDesc() {
		return Description;
	}
	
	public void setDesc(String description) {
		this.Description = description;
	}
	
	public Integer getPriority() {
		return Priority;
	}
	
	public void setPriority(Integer Priority) {
		this.Priority = Priority;
	}
	
	public Integer getSubmitID() {
		return SubmitUserID;
	}
	
	public void setSubmitID(Integer id) {
		this.SubmitUserID = id;
	}
	
	public Integer getDoneID() {
		return SubmitUserID;
	}
	
	public void setDoneID(Integer id) {
		this.SubmitUserID = id;
	}
	
	public Integer getStatus() {
		return Status;
	}
	
	public void setStatus(Integer status) {
		this.Status = status;
	}
	
//	public boolean setFile(Integer file) {
//		return Files.add(file);
//	}
	
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
        Task other = (Task) obj;
        if (TaskId == null) {
            if (other.TaskId != null) {
            	return false;
            }else {
            	return true;
            }
        } else if (!TaskId.equals(other.TaskId)) {
        	return false;
        }else {
        	return true;
        } 
    }
	
//	public Task() {
//		this.TaskId = null;
//		this.TaskName = null;
//		this.Description = null;
//		this.Priority = null;
//		this.Status = null;
//		this.SubmitUserID = null;
//		this.DoneUserID = null;
//	}

}
