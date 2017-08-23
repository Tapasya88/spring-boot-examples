package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Singer implements Performer {

	

	@Override
	public void perform() {
		
		System.out.println("Singer is now Singing");
		

	}

}
