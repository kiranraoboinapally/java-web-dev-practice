package com.firstproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext app=new ClassPathXmlApplicationContext("data.xml");
    	System.out.println(app.getBean("student1",Student.class));
    	System.out.println(app.getBean("student2",Student.class));
    	System.out.println(app.getBean(Employee.class));
    	System.out.println(app.getBean(College.class));//ref used in xml tags data.xml for classes configuration
    	//ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("data.xml");
    	System.out.println(app.getBean(Order.class));
    }
}
