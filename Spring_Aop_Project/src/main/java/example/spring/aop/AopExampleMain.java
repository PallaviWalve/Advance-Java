package example.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopExampleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
		
		Musician musicianRef = context.getBean(Musician.class);
		musicianRef.perform();
		
		String className = musicianRef.getClass().getName();
		System.out.println(className);
		
		System.out.println("------------------------------------");
		Singer singerRef = context.getBean(Singer.class);
		singerRef.perform();
		className = singerRef.getClass().getName();
		System.out.println(className);
		
	}

}
