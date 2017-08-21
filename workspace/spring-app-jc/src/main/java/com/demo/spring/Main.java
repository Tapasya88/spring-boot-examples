package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.config.AppConfig;

public class Main {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// EmpService service= ctx.getBean(EmpService.class);
		Thread.sleep(10000);
		EmpService service = (EmpService) ctx.getBean("empService");
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 30000));

	}

}
