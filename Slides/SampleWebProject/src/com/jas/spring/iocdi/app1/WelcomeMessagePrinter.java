package com.jas.spring.iocdi.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessagePrinter {

	private WelcomeMessageService welcomeMessageService;

	@Autowired
	public WelcomeMessagePrinter(WelcomeMessageService welcomeMessageService) {
		this.welcomeMessageService = welcomeMessageService;
	}
	
	public void printMessage() {
		System.out.println(welcomeMessageService.getMessage());
	}
}
