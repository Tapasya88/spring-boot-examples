package com.demo.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Emp;
import com.demo.spring.EmpService;

@RestController
public class MyRestResource {

	@Autowired
	EmpService service;

	@RequestMapping(path = "/message", method = RequestMethod.GET)
	public String getMessage() {
		return "hi From boot app";
	}

	@RequestMapping(path = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getAll() {
		return service.getEmpList();
	}
}
