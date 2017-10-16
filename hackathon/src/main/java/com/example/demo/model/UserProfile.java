package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	public String userId;
	public String name;
	
	public UserProfile(int id, String userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
	}
	
	public UserProfile() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
