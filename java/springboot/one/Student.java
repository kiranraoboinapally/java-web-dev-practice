package com.spring1;

class Student {
		int roll;
		String name;
		Employee employee;
		public Student(int roll, String name, Employee employee) {
			super();
			this.roll = roll;
			this.name = name;
			this.employee = employee;
		}
		@Override
		public String toString() {
			return "Student [roll=" + roll + ", name=" + name + ", employee=" + employee + "]";
		}
		
}
