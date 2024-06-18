package example.spring.aop;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component
public class Singer {
	public void perform() {
		System.out.println("Singing a Song...");
		throw new RuntimeException();
	}
}
