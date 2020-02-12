package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;

public class MentorSkillForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer mentor;
	private String name;
	private Integer technologyId;
	private String technology;
	private Integer experience;
	private Integer noOfTrainings;
	private Integer fee;
	private String status;
	private Boolean proposed;
	
	@Override
	public String toString() {
		return String.format(
	    	"MentorSkillForm[id=%d, name=%s, technology=%s, experience='%d', noOfTrainings=%d, fee=%d, status='%s']",
	        id, name, technology, experience, noOfTrainings, fee, status);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMentor() {
		return mentor;
	}

	public void setMentor(Integer mentor) {
		this.mentor = mentor;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	public Integer getNoOfTrainings() {
		return noOfTrainings;
	}

	public void setNoOfTrainings(Integer noOfTrainings) {
		this.noOfTrainings = noOfTrainings;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Boolean getProposed() {
		return proposed;
	}

	public void setProposed(Boolean proposed) {
		this.proposed = proposed;
	}

	

}
