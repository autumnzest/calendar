package com.kame.domain;

import java.io.Serializable;
import java.sql.Timestamp;


public class AdminInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String password;
	private Timestamp created_at;
	
	public AdminInfo() {
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
	
	@Override
	public String toString() {
		return "admin_list [id=" + id + ", name="
				+ name + "]";
	}





}
