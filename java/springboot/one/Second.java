package com.spring1;

public class Second {
	First first=new First();
	Third third=new Third();
	public static void main(String args[]) {
		Second second=new Second();
		second.method1();	}
		public void method1()
		{
			System.out.println("I am method1 in Second");
			first.method1();
			third.method1();
		}
}
