package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;
import java.sql.Date;

public class TrainingSearchForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer technology;
	private Date startdate;
	private Date enddate;
	private Integer scholar;
	
	@Override
	public String toString() {
		return String.format(
	    	"TrainingSearchForm[technology=%d, startdate='%s', enddate='%s']",
	    	technology, startdate, enddate);
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
	
	public Integer getScholar() {
		return scholar;
	}

	public void setScholar(Integer scholar) {
		this.scholar = scholar;
	}

	
}
