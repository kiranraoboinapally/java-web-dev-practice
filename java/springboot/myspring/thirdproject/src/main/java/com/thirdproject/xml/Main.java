package com.thirdproject.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("Data.xml");
		System.out.println(context.getBean(College.class));
		context.registerShutdownHook();
		
	}

}
