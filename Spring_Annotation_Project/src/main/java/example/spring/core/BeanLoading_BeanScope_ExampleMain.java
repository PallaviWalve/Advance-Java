package example.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLoading_BeanScope_ExampleMain {

	public static void main(String[] args) {
		Class<SpringConfig> configClass = SpringConfig.class;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configClass);
		
		context.getBean("matchResult"); 
		
		Object obj = context.getBean("matchResult2");
		Object obj2 = context.getBean("matchResult2");
		System.out.println(obj == obj2);
	}

}
