package com.ibm.fsd.casestudy.mod.formbean;

import java.io.Serializable;

public class TechnologyForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer duration;
	private Integer cost;
	
	@Override
	public String toString() {
		return String.format(
	    	"TechnologyForm[id=%d, name='%s', duration='%d', cost='%d']",
	        id, name, duration, cost);
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
