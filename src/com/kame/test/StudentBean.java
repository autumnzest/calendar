package com.kame.test;

public class StudentBean implements java.io.Serializable{
	private String firstname = null;
	private String lastname = null;
	private int age = 0;
	
	public StudentBean() {
		
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setFirstName(String firstName) {
		this.firstname = firstname;
	}
	
	public void setLastName(String lastName) {
		this.lastname = lastname;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
