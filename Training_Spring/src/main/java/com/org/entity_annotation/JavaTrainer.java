package com.org.entity_annotation;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JavaTrainer implements Trainer{

	private String name;
	private List<String> modules;
	
	public JavaTrainer() {
		System.out.println("Default Constructor of Java Trainer");
	}

	public JavaTrainer(String name, List<String> modules) {
		super();
		this.name = name;
		this.modules = modules;
		System.out.println("Parameterized Constructor of Java Trainer");
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}
	
	@Override
	public void train() {
		System.out.println(name + " is teaching " + modules);
	}

	@Override
	public String toString() {
		return "JavaTrainer [name=" + name + ", modules=" + modules + "]";
	}
	
	
}
