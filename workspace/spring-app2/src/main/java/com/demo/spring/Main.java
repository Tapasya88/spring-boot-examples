package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		// EmpService service= ctx.getBean(EmpService.class);
		Thread.sleep(10000);
		EmpService service = (EmpService) ctx.getBean("empService");
		System.out.println(service.registerEmployee(100, "James", "Hyderabad", 30000));

	}

}
