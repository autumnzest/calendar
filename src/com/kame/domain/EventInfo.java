package com.kame.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class EventInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int userid;
	private Timestamp eventdate;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String info;
	
	public EventInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}
	
	public Timestamp getEventdate() {
		return eventdate;
	}

	public void setEventdate(Timestamp eventdate) {
		this.eventdate = eventdate;
	}
	
	public Timestamp getCreatedate() {
		return created_at;
	}
	
	public Timestamp getUpdate() {
		return updated_at;
	}
	
	public void setInfo() {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}	

	@Override
	public String toString() {
		return "info";
	}
}
