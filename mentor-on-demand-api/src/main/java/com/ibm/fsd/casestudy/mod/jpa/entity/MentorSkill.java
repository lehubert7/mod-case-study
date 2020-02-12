package com.ibm.fsd.casestudy.mod.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentorskills")
public class MentorSkill {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer mentor;
	private Integer technology;
	private Integer experience;
	private String status;
	
	public MentorSkill() {
	}
	
	public MentorSkill(Integer id, Integer mentor, Integer technology, Integer experience, String status) {
		this.id = id;
		this.mentor = mentor;
		this.technology = technology;
		this.experience = experience;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format(
	    	"MentorSkills[id=%d, mentor=%d, technology=%d, experience=%d, status='%s']",
	        id, mentor, technology, experience, status);
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
	public Integer getTechnology() {
		return technology;
	}
	public void setTechnology(Integer technology) {
		this.technology = technology;
	}
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
