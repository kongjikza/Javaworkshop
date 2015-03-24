package com.jas.spring.iocdi.app1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApplication1 {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(HelloApplicationConfig.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
		
		ApplicationContext context2 =
				new AnnotationConfigApplicationContext(WelcomeApplicationConfig.class);
		WelcomeMessagePrinter printer2 = context2.getBean(WelcomeMessagePrinter.class);
		printer2.printMessage();
	}
}


