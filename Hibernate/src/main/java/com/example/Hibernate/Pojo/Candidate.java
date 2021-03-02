package com.example.Hibernate.Pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "candidate")
public class Candidate {

	private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String applyingForPosition;
    private String emailId;
    private String phone;
    private String linkedIn;
    private Address address;
   
    
	public Candidate() {
		super();
	}
	public Candidate(String firstName, String lastName, Date dateOfBirth, String applyingForPosition, String emailId,
			String phone, String linkedIn, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.applyingForPosition = applyingForPosition;
		this.emailId = emailId;
		this.phone = phone;
		this.linkedIn = linkedIn;
		this.address = address;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DateTimeFormat(iso=ISO.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "position")
	public String getApplyingForPosition() {
		return applyingForPosition;
	}
	public void setApplyingForPosition(String applyingForPosition) {
		this.applyingForPosition = applyingForPosition;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "phoneNo", nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "LinkedIn", nullable = true)
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	@OneToOne
	@JoinColumn(name="zip_code")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Candidate [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", applyingForPosition=" + applyingForPosition + ", emailId=" + emailId + ", phone=" + phone
				+ ", linkedIn=" + linkedIn + ", address=" + address + "]";
	}

    
    
    
    
}
