package com.example.Hibernate.Pojo;

import java.util.Collection;
import javax.persistence.*;


@Entity
@Table(name = "employees")
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
    private String password;
    private Collection<Role> roles;
    
    
    
    public User() {
		super();
	}
  
	public User(String firstName, String lastName, String emailId, String phone, String password,
			Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
		this.roles = roles;
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


	
	@Column(name = "password", nullable = true)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn(
			name= "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(
			name="role_id", referencedColumnName="id"))
	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phone=" + phone
				+ ", password=" + password + ", roles=" + roles + "]";
	}

	
	

}
