package com.thirdproject.xml;

public class College {
	String name;
	String cname;
	Student student;
	void m1()
	{
		System.out.println("I am m1");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "College [name=" + name + ", cname=" + cname + ", student=" + student + "]";
	}

}
