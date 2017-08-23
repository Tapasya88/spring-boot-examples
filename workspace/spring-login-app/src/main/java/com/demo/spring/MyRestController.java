package com.demo.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping(path="/greet")
	public String greet(){
		return "Hi, This is REST data";
	}
}
