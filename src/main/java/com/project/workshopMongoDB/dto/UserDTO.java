package com.project.workshopMongoDB.dto;

import java.io.Serializable;

import com.project.workshopMongoDB.data.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String lastName;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		id = obj.getId();
		firstName = obj.getFirstName();
		lastName = obj.getLastName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
