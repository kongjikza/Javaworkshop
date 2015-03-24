package com.jas.spring.iocdi.app1;

public class WelcomeMessageServiceImpl implements WelcomeMessageService {

	public String getMessage() {
		return "Welcome, using Autowired";
	}
}
