package com.org.test;

import java.util.ArrayList;
import java.util.List;

import com.org.entity.JavaTrainer;
import com.org.entity.JavaWorkshop;
import com.org.entity.MetInfoTech;
import com.org.entity.Trainer;
import com.org.entity.TrainingCompany;
import com.org.entity.Workshop;

public class NonSpringTest {
	public static void main(String[] args) {
		List<String> modules = new ArrayList<>();
		modules.add("OOP");
		modules.add("Collection");
		modules.add("Threading");
		
		Trainer trainer = new JavaTrainer("Jack", modules);
		
		TrainingCompany company = new MetInfoTech(trainer);
		
		Workshop javaWorkshop = new JavaWorkshop(company);
		
		javaWorkshop.conductWorkshop();
	}
}
