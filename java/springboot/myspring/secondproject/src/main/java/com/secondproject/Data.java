package com.secondproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Data {
@Bean
public Student s1()
	{
	return new Student(101,"Kira");
	}
@Bean
public Employee e1()
	{
		Employee employee=new Employee();
		employee.setId(101);
		employee.setLocation("JNTU");
		return employee;
	}
@Bean
public College c1()
	{	
	return new College("Aryan",s1(),e1());
	}
}
