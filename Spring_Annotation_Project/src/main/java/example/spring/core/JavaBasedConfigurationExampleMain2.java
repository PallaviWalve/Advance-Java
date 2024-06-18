package example.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfigurationExampleMain2 {

	public static void main(String[] args) {
		
		Class<SpringConfig> configClass = SpringConfig.class;
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configClass);
	
		Object loadedObject = context.getBean("greet");
		GreetingService gs = (GreetingService)loadedObject;
		String reply = gs.sayGreeting();
		System.out.println(reply);
	}

}
