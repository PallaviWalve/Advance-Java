package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringDependencyInjectionExampleMain {

	public static void main(String[] args) {
		ApplicationContext context;
		String configPath = "./src/main/resources/spring-config.xml";
		context = new FileSystemXmlApplicationContext(configPath);
		Object loadedObject = context.getBean("greet4"); //is not helloservice at every time thats why taking object
		GreetingService gs = (GreetingService)loadedObject;  //downcasting  if typecast it with classtype it give exception because there is two class implements same interface
		String reply = gs.sayGreeting();
		System.out.println(reply);
		
		System.out.println("--------------------------------------------------------");
		loadedObject = context.getBean("greet5"); //called 1st Parameterized constructor
		gs = (GreetingService)loadedObject;
		reply = gs.sayGreeting();
		System.out.println(reply);
		
	}

}
