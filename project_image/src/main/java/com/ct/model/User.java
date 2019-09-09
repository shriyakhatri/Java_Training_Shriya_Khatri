package com.ct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_details")
public class User {

	/*@Id @GeneratedValue
	private int id;*/
	@Id
	

@NotEmpty(message="This field is Mandatory")
@Size(min=3,max=16,message="name should be more than 3 & less than 16")
	private String username;
	
	@NotEmpty(message="This field is Mandatory")
	@Size(min=3,max=16,message="password should be more than 3 & less than 16")	
private String password;
	

	
	public User( String username, String password, String address, int contact_no) {
		super();
		//this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact_no = contact_no;
	}
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	private String address;
	private int contact_no;
	

public User() {
	super();
	// TODO Auto-generated constructor stub
}
}