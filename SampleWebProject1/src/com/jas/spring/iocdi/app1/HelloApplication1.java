package com.jas.spring.iocdi.app1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class HelloApplication1 {
// การใช้ Spring Contentner
	public static void main(String[] args) {
		ApplicationContext context = 
		          new AnnotationConfigApplicationContext(HelloApplicationConfig.class);
		//แบบนี้มีการยืดหยุ่นกว่า app 2 เพราะเราไม่ต้องมานั่งแก้โค็ตทีหลังเวลาจะแก้ไข Class
		//AnnotationConfig คือการกำหนเให้ไม่ต้องมี xml เลย
		
		System.out.println("HelloApplication1");
		      MessagePrinter printer = context.getBean(MessagePrinter.class);
		      printer.printMessage();    
		      
		      //ปกติเขียนแบบนี้
//		      MessageService ms = new HelloMessageServiceImpl();
//		      MessagePrinter printer  = new MessagePrinter(ms);
//		      printer.printMessage();
	}
}
