package com.jas.spring.iocdi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // เป็น Annotation เป็นการบอกว่า Class เป็น Controller


@RequestMapping("/hello")
public class HelloController {
	
	private MessageService messageService;
	
	@Autowired
	public HelloController(MessageService messageService) {
		this.messageService = messageService;
	}

	// เวลาเข้าที่ URL จะเป็นแบบนี้   --> SimpleWebProject/spring/hello/message
	@RequestMapping(value = "message", method=RequestMethod.GET) 
	@ResponseBody
    public String message(Model model) {
        return messageService.getMessage();
    }
}
