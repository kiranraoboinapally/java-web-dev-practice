package com.spring1;

import java.util.Set;
import java.util.Arrays;
import java.util.List;

public class Employee {

	int roll;
	String name;
	int[] a;
	Set<Integer>set;
	List<String>list;
	public Employee(int roll, String name, int[] a, Set<Integer> set, List<String> list) {
		super();
		this.roll = roll;
		this.name = name;
		this.a = a;
		this.set = set;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Employee [roll=" + roll + ", name=" + name + ", a=" + Arrays.toString(a) + ", set=" + set + ", list="
				+ list + "]";
	}

}
