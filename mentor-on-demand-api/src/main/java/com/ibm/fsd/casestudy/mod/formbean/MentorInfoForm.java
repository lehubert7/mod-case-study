package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;
import java.util.List;

public class MentorInfoForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	private String designation;
	private String location;
	private List<String> skills;
	
	@Override
	public String toString() {
		return String.format(
	    	"MentorInfoForm[id=%d, name='%s', email=%s, designation=%s, location='%s']",
	        id, name, email, designation, location);
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
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	
}
