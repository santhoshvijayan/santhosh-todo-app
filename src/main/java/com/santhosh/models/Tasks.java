package com.santhosh.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tasks {
	
	@Id
	private String id;
	
	@NotNull
	@Size(min=5, max=30)
	private String taskname;
	
	@NotNull
	private Date performdate;
	
	@NotNull
	@Size(min=3, max=15)
	private String category;
	
	private Priority priority;
		
	@NotNull
	private Boolean isdone;
	
	public Tasks(String taskname, Date performdate, String category, Priority priority, Boolean isdone){
		this.taskname = taskname;
		this.performdate = performdate;
		this.category = category;
		this.priority = priority;
		this.isdone = false;
	}

	public Tasks(){
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return taskname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public Date getPerformdate() {
		return performdate;
	}

	public String getCategory() {
		return category;
	}

	public Priority getPriority() {
		return priority;
	}
	
	public Boolean getIsdone() {
		return isdone;
	}

}
