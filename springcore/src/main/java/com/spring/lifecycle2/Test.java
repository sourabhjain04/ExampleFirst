package com.spring.lifecycle2;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/spring/lifecycle2/config.xml");
	
		Pepsi p2 = (Pepsi) context.getBean("p2");
		System.out.println(p2);
		context.registerShutdownHook();
	}

}
