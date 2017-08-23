package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.config.AppConfig;

public class EmpServiceClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService service=(EmpService)ctx.getBean("empService");
		
		System.out.println(service.registerEmployee(201, "James", "Bangalore", 30000));

	}

}
