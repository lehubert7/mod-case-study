package com.ibm.fsd.casestudy.mod.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technologies")
public class Technology {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer duration;
	private Integer cost;
	
	public Technology(Integer id, String name, Integer duration, Integer cost) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return String.format(
	    	"Technology[id=%d, name='%s', duration='%d', cost='%d']",
	        id, name, duration, cost);
	}
	
	public Technology() {
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
