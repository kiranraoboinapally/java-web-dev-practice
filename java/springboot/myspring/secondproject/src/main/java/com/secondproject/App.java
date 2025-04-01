package com.secondproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Data.class);
    	System.out.println(context.getBean("s1",Student.class));
    	System.out.println(context.getBean(Employee.class));
    	System.out.println(context.getBean(College.class));
    	
    }
}
