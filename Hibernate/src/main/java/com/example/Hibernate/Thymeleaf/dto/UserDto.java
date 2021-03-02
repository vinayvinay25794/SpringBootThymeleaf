package com.example.Hibernate.Thymeleaf.dto;

import java.util.Date;

import com.example.Hibernate.Pojo.Address;

public class UserDto {

	private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
    private String password;
    
    

	public UserDto() {
		super();
	}

	public UserDto(String firstName, String lastName, String emailId,
			String phone, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
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
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
    
    
}
