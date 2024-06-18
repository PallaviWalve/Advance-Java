package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration //Marks this class as a configuration unit
public class SpringConfig {
	//This class is equivalent to spring-config.xml
	
	@Bean //Marks this method as Bean Registration method
	//The default ID is the method name: getHelloBean
	public GreetingService  getHelloBean() {
		GreetingService gs = new HelloService();
		return gs;
	}

	@Bean("greet") //overrides the default ID and assigns a new one
	public GreetingService  getWelcomeBean() {
		GreetingService gs = new WelcomeService();
		return gs;
	}

	@Bean
	@Lazy //Mark the bean lazy
	public GreetingService  matchResult() {
		//This is equivalent to setter Injection
		
		CricketMatchResult result = new CricketMatchResult();
		result.setWinningteam("India");
		result.setLosingTeam("Pakistan");
		result.setWinningMargin(6);
		result.setWinningType("Runs");
		return result;
	}
	
	@Bean
	@Scope("prototype")
	public GreetingService matchResult2() {
		//This is equivalent to constructor Injection
		GreetingService gs = new CricketMatchResult(8, "India", "Ireland", "Wickets");
		return gs;
	}
}
