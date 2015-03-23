package com.jas.spring.iocdi.app1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class HelloApplication1 {
// ����� Spring Contentner
	public static void main(String[] args) {
		ApplicationContext context = 
		          new AnnotationConfigApplicationContext(HelloApplicationConfig.class);
		//Ẻ����ա���״���蹡��� app 2 �����������ͧ�ҹ�����絷���ѧ���Ҩ���� Class
		//AnnotationConfig ��͡�á�˹��������ͧ�� xml ���
		
		System.out.println("HelloApplication1");
		      MessagePrinter printer = context.getBean(MessagePrinter.class);
		      printer.printMessage();    
		      
		      //������¹Ẻ���
//		      MessageService ms = new HelloMessageServiceImpl();
//		      MessagePrinter printer  = new MessagePrinter(ms);
//		      printer.printMessage();
	}
}
