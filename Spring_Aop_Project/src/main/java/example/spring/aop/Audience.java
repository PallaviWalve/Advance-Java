package example.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect //Marks this class as an aspect
@Component
public class Audience {
	
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	private void myPointCut() {}
	
	
	
	@Before("myPointCut()")
	public void takeSeats() {
		System.out.println("Please take your seats");
	}
	
	@Before("myPointCut()")
	public void turnOffMobiles() {
		System.out.println("Please turn off your mobiles");
	}
	
	@AfterReturning("myPointCut()")
	public void clap() {
		System.out.println("Clap Clap Clap");
	}
	
	@AfterThrowing("myPointCut()")
	public void demandForRefund() {
		System.out.println("Please give our Money back");
	}
	
	@After("myPointCut()")
	public void leave() {
		System.out.println("Bye, Leaving now");
	}
}
