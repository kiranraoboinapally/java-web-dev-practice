package com.firstproject;

public class College {
	 Student student;
	 Employee employee;
	 public Student getStudent() {
	  return student;
	 }
	 public void setStudent(Student student) {
	  this.student = student;
	 }
	 public Employee getEmployee() {
	  return employee;
	 }
	 public void setEmployee(Employee employee) {
	  this.employee = employee;
	 }
	 @Override
	 public String toString() {
	  return "College [student=" + student + ", employee=" + employee + "]";
	 }
	}
