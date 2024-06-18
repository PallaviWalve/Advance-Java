package example.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import desserts.IceCream;
import desserts.brownies.WalnutBrownies;
import juices.OrangeJuice;
import milkshakes.MangoMilkShake;

public class PureAnnotationBasedConfigurationExampleMain {

	public static void main(String[] args) {
		Class<SpringConfig3> configClass = SpringConfig3.class;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configClass);
		
		Class<MyComponent> componentType = MyComponent.class;
		MyComponent myCompRef = context.getBean(componentType);
		myCompRef.testMyComponent();
		
		Class<OrangeJuice> juiceComp = OrangeJuice.class;
		OrangeJuice juiceRef = context.getBean(juiceComp);
		juiceRef.tasteOrangeJuice();
		
		Class<MangoMilkShake> shakeComp = MangoMilkShake.class;
		MangoMilkShake shakeRef = context.getBean(shakeComp);
		shakeRef.tasteMangoMilkShake();
		
		Class<IceCream> iceCreamComp = IceCream.class;
		IceCream iceCreamRef = context.getBean(iceCreamComp);
		iceCreamRef.tasteMangoIceCream();
		
		Class<WalnutBrownies> brownieComp = WalnutBrownies.class;
		WalnutBrownies brownieRef = context.getBean(brownieComp);
		brownieRef.tasteWalnutBrownie();
	}

}
