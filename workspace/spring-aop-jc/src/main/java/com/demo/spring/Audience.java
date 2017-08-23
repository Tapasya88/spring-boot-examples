package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Pointcut("execution(* com..spring.Performer.perform(..))")
	public void pcut(){}
	
	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience take seats..");
	}

	@Before("pcut()")
	public void switchOfMobile() {
		System.out.println("Audience Switched off  their mobiles...");
	}

	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Clap! Clap! Clap!...");
	}

	public void demandRefund(Throwable t) {
		System.out.println("We want our money back!!!....");
	}
}
