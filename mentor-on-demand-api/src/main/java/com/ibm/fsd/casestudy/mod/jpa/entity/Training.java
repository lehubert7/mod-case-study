package com.ibm.fsd.casestudy.mod.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainings")
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer scholar;
	private Integer mentor;
	private Integer technology;
	private Date startdate;
	private Date enddate;
	private Integer progress;
	private String status;
	
	public Training() {
	}
	
	public Training(Integer id, Integer scholar, Integer mentor, Integer technology, 
			Date startdate, Date enddate, Integer progress, String status) {
		this.id = id;
		this.scholar = scholar;
		this.mentor = mentor;
		this.technology = technology;
		this.startdate = startdate;
		this.enddate = enddate;
		this.progress = progress;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format(
	    	"Training[id=%d, scholar='%d', mentor='%d', technology='%d', startdate='%s', "
				+ "enddate='%d', progress='%d', status='%s']", id, scholar, mentor,
				technology, startdate, enddate, progress, status);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScholar() {
		return scholar;
	}
	public void setScholar(Integer scholar) {
		this.scholar = scholar;
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
