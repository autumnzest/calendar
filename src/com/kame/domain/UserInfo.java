package com.kame.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String password;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getPswd() {
		return password;
	}

	public void setPswd(String pswd) {
		this.password = pswd;
	}
	
	public Timestamp getCreatedate() {
		return created_at;
	}
	
	public Timestamp getUpdate() {
		return updated_at;
	}
	
	@Override
	public String toString() {
		return "user_list [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}





}
