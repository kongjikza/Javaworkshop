package com.jas.guice;

import com.google.inject.AbstractModule;

public class HelloModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MessageService.class).to(HelloMessageServiceImpl.class);
		
		// bind ��͡������� �繡���͡Ẻ���������ٻẺ�ͧ����¤
	}
}
