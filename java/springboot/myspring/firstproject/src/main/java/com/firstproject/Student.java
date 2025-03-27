package com.firstproject;

public class Student {
	int roll;
	String name,email;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + "]";
	}
	/*Student()
	{
		System.out.println("constructor");//this for line 13  in App.java
	}*/
}
