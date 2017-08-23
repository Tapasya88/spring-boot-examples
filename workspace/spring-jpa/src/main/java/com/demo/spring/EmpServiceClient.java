package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.config.AppConfig;

public class EmpServiceClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		EmpService service = (EmpService) ctx.getBean("empService");

		// System.out.println(service.registerEmployee(203, "Arun", "Chennai",
		// 30000));
		List<Emp> empList = service.getEmpList();

		for (Emp e : empList) {
			System.out.println(e.getName() + " " + e.getSalary());
		}

	}

}
