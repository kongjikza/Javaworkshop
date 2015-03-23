package com.jas.spring.iocdi.app1;

public class HelloMessageServiceImpl implements MessageService {

	public String getMessage() {
		
		System.out.println("HelloMessageServiceImpl");
		return "Hello, using Autowired";
	}
}
