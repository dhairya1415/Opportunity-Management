package com.accolite.oppmang.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Opportunity {
	private int oppid;
	private String manager_name;
	private String manager_email;
	private String description;
	private String location;
	private String skills;
	private int min_exp;
	private int demand;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate joining_date;
	
	//Constructor
	public Opportunity() { }
	public Opportunity(String manager_name, String manager_email, String description, String location, String skills,
			int min_exp, int demand, LocalDate joining_date) {
		super();
		this.manager_name = manager_name;
		this.manager_email = manager_email;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.min_exp = min_exp;
		this.demand = demand;
		this.joining_date = joining_date;
	}
	
	//Getters And Setters
	public int getOppid() {
		return oppid;
	}

	public void setOppid(int oppid) {
		this.oppid = oppid;
	}
	
	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_email() {
		return manager_email;
	}
	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getMin_exp() {
		return min_exp;
	}
	public void setMin_exp(int min_exp) {
		this.min_exp = min_exp;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	public LocalDate getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(LocalDate joining_date) {
		this.joining_date = joining_date;
	}

	//Override toString
	@Override
	public String toString() {
		return "Opportunity [oppid=" + oppid + ", manager_name=" + manager_name + ", manager_email=" + manager_email
				+ ", description=" + description + ", location=" + location + ", skills=" + skills + ", min_exp="
				+ min_exp + ", demand=" + demand + ", joining_date=" + joining_date + "]";
	}
	
}
