package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.config.AppConfig;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Performer p=(Performer)ctx.getBean("singer");
		System.out.println(p.getClass().getName());
		p.perform();

	}

}
