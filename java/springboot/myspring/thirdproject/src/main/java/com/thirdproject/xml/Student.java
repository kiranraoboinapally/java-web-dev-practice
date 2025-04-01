package com.thirdproject.xml;

public class Student {
	String name,email;
	int roll;
	public Student(String name, String email, int roll) {
		super();
		this.name = name;
		this.email = email;
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", roll=" + roll + "]";
	}
	
}
