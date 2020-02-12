package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;

public class LoginForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String usertype;
	private String location;
	
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
