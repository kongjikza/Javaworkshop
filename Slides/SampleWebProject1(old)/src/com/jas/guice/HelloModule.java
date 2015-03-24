package com.jas.guice;

import com.google.inject.AbstractModule;

public class HelloModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MessageService.class).to(HelloMessageServiceImpl.class);
		
		// bind คือการเชื่อม เป็นการออกแบบให้อยู่ในรูปแบบของประโยค
	}
}
