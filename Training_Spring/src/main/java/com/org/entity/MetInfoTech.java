package com.org.entity;

public class MetInfoTech implements TrainingCompany {

	private Trainer trainer;
	
	
	public MetInfoTech() {
		super();
		System.out.println("Default Constructor of MetInfoTech");
	}

	public MetInfoTech(Trainer trainer) {
		super();
		this.trainer = trainer;
		System.out.println("Parameterized Constructor of MetInfoTech");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public void conductTraining() {
		System.out.println("MetInfoTech Conducting Training");
		trainer.train();
	}
	
	@Override
	public String toString() {
		return "MetInfoTech [trainer=" + trainer + "]";
	}

}
