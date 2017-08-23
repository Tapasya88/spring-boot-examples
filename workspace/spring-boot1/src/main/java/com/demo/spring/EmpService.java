package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	EmpDao dao;

	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}

	public List<Emp> getEmpList() {
		return dao.getAllEmps();
	}
}
