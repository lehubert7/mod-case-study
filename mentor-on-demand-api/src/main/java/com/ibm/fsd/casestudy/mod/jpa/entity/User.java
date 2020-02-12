package com.ibm.fsd.casestudy.mod.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String usertype;
	private String location;
	
	public User() {
	}

	
	public User(Integer id, String name, String email, String password, String usertype, String location) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return String.format(
	    	"User[id=%d, name='%s', email='%s', password='%s', usertype='%s', location='%s']",
	        id, name, email, password, usertype, location);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
