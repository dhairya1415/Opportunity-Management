package com.accolite.oppmang.models;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.time.ZoneId;

public class Audit {
	private int audid;
	private String user_name;
	private String user_email;
	private String timestamp;
	private String action;
	private String initial;
	private String updated;
	private int oppid;
	
	//Constructor
	public Audit () { }
	
	public Audit(String user_name, String user_email, String action, String initial, String updated, int oppid) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.action = action;
		this.initial = initial;
		this.updated = updated;
		//TimeStamp
		ZoneId zid = ZoneId.of("Asia/Kolkata");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(zid);
        this.timestamp = dtf.format(now).toString();
        this.oppid = oppid;
	}

//	public Audit(String user_name, String user_email, String timestamp, String action, String initial, String updated) {
//		super();
//		this.user_name = user_name;
//		this.user_email = user_email;
//		this.timestamp = timestamp;
//		this.action = action;
//		this.initial = initial;
//		this.updated = updated;
//	}

	//Getters and Setter
	public int getAudid() {
		return audid;
	}
	public void setAudid(int audid) {
		this.audid = audid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public int getOppid() {
		return oppid;
	}
	public void setOppid(int oppid) {
		this.oppid = oppid;
	}


	@Override
	public String toString() {
		return "Audit [audid=" + audid + ", user_name=" + user_name + ", user_email=" + user_email + ", timestamp="
				+ timestamp + ", action=" + action + ", initial=" + initial + ", updated=" + updated + "]";
	}
	
	
}
