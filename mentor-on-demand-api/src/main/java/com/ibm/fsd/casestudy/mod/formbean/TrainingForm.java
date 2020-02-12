package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;
import java.sql.Date;

public class TrainingForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer scholarId;
	private String scholar;
	private Integer mentorId;
	private String mentor;
	private Integer technologyId;
	private String technology;
	private Date startdate;
	private Date enddate;
	private Integer progress;
	private String status;
	
	@Override
	public String toString() {
		return String.format(
	    	"Training[id=%d, scholar='%d', mentor='%d', technology='%d', startdate='%s', "
				+ "enddate='%s', progress='%d', status='%s']", id, scholar, mentor,
				technology, startdate, enddate, progress, status);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScholarId() {
		return scholarId;
	}

	public void setScholarId(Integer scholarId) {
		this.scholarId = scholarId;
	}

	public Integer getMentorId() {
		return mentorId;
	}

	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public void setScholar(String scholar) {
		this.scholar = scholar;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getScholar() {
		return scholar;
	}
	public String getMentor() {
		return mentor;
	}
	public String getTechnology() {
		return technology;
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
