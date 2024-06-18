package example.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan //asking spring to scan the components

@ComponentScan(basePackages = {"juices" , "milkshakes", "desserts", "example"}) //no need to write brownies because its sub package of desserts
public class SpringConfig3 {
 //@Bean methods if any
}
