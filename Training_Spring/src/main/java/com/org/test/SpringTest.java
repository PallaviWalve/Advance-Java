package com.org.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.entity.JavaWorkshop;

public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		JavaWorkshop adJavaWorkshop = context.getBean(JavaWorkshop.class);
		
		adJavaWorkshop.conductWorkshop();
	}

}
