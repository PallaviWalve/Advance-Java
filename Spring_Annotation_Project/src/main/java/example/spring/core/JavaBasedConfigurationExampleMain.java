package example.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfigurationExampleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		Class<SpringConfig> configClass = SpringConfig.class;
		
		context.register(configClass); //Registration configuration unit
		
		context.refresh();//Refreshing context to apply changes
		
		Object loadedObject = context.getBean("greet");
		GreetingService gs = (GreetingService)loadedObject;
		String reply = gs.sayGreeting();
		System.out.println(reply);
	}

}
