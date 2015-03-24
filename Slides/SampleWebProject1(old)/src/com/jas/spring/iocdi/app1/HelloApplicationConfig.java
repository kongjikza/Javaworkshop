package com.jas.spring.iocdi.app1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HelloApplicationConfig {

	@Bean // ทำหน้าที่แทน Xml ในแบบที่ 2 คือ app2
	public MessageService mockMessageService() {
		
		System.out.println("HelloApplicationConfig");
		return new HelloMessageServiceImpl();
	}
}
