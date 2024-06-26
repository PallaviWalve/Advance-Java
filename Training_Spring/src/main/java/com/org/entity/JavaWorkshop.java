package com.org.entity;

public class JavaWorkshop implements Workshop {
	
	private TrainingCompany company;
	
	public JavaWorkshop() {
		super();
		System.out.println("Default Constructor of JavaWorkshop");
	}
	
	public JavaWorkshop(TrainingCompany company) {
		super();
		this.company = company;
		System.out.println("Parameterized Constructor of JavaWorkshop");
	}

	public TrainingCompany getCompany() {
		return company;
	}

	public void setCompany(TrainingCompany company) {
		this.company = company;
	}

	@Override
	public void conductWorkshop() {
		System.out.println("Java workshop started!!!!");
		company.conductTraining();
	}
	
	@Override
	public String toString() {
		return "JavaWorkshop [company=" + company + "]";
	}


}
