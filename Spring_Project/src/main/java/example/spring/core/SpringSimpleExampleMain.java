package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleExampleMain {

	public static void main(String[] args) {
		ApplicationContext context;
		String configPath = "./src/main/resources/spring-config.xml";
		context = new FileSystemXmlApplicationContext(configPath);
		Object loadedObject = context.getBean("greet3"); //is not helloservice at every time thats why taking object
		GreetingService gs = (GreetingService)loadedObject;  //downcasting  if typecast it with classtype it give exception because there is two class implements same interface
		String reply = gs.sayGreeting();
		System.out.println(reply);
	}

}
