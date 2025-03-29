package com.secondproject;

public class College {
	String name;
	Student student;
	Employee employee;
	public College(String name, Student student, Employee employee) {
		super();
		this.name = name;
		this.student = student;
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", student=" + student + ", employee=" + employee + "]";
	}
}
