package com.org.entity_annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		JavaTrainer javaTrainer = context.getBean(JavaTrainer.class);
		javaTrainer.setName("Jeff");
		List<String> modules = new ArrayList<String>();
		modules.add("OOP");
		modules.add("Exception Handling");
		modules.add("Reflection");
		javaTrainer.setModules(modules);
		
		JavaWorkshop workshop = context.getBean(JavaWorkshop.class);
		
		workshop.conductWorkshop();
	}

}
