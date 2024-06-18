package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeExampleMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config3.xml");
		Object obj = context.getBean("myBean3"); //1st request
		Object obj2 = context.getBean("myBean3"); //2nd request
		
		System.out.println(obj == obj2); //check whether 2 object referring to same object ==singleton
		
		System.out.println("-------------------------");
		
		obj = context.getBean("myBean4"); //1st request
		obj2 = context.getBean("myBean4"); //2nd request
		
		System.out.println(obj == obj2); //check whether 2 object referring to same object == prototype
	}

}
