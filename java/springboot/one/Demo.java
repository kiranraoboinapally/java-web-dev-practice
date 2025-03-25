package com.spring1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {	
		int a[]=new int[]{1,3,12,32,25};
		Set<Integer>set=new HashSet<Integer>(Arrays.asList(10,20,30,40,50));
		List<String>list=new LinkedList<String>(Arrays.asList("Hyd","kphb","abc"));
		Employee emp=new Employee(10,"Kiran",a,set,list);
		System.out.println(emp);
		Student std=new Student(101,"aryan",emp);
		System.out.println(std);
	}
}
