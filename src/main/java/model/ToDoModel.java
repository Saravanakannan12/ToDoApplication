package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "todoTable")
public class ToDoModel {
	
	//Primary key for the table
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	
	private String description;
	
	private Date endDate;
	
	//Annotation saves the date from VM whenever it creates a new entity
	@CreationTimestamp
	@Temporal(TemporalType.TIME)
	private Date createDate;
	
	//this annotation saves the date from VM whenever there is an update to the table
	@UpdateTimestamp
	@Temporal(TemporalType.TIME)
	private Date modifiedDate;
	
	
	

	public ToDoModel() {
		super();
	}

	public ToDoModel(String userName, String description, Date endDate, boolean isDone, Date createDate, Date modifiedDate) {
		super();
		this.userName = userName;
		this.description = description;
		this.endDate = endDate;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}