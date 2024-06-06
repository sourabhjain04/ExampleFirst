package com.spring.stereotype;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/stereotype/config.xml");
	
	Student	student =  context.getBean("ob",Student.class);
		System.out.println(student.hashCode());
		Student	student1 =  context.getBean("ob",Student.class);
		System.out.println(student1.hashCode());
	}

}
