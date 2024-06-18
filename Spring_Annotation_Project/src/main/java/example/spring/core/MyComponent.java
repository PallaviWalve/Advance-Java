package example.spring.core;

import org.springframework.stereotype.Component;

@Component //marks this class as component so that spring can manage it
public class MyComponent {

	public void testMyComponent() {
		System.out.println("My component test works....");
	}
}
