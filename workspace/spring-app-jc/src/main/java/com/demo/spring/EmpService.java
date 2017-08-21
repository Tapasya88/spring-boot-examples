package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired  //no need to write a setter
	EmpDao dao;

	/*public void setDao(EmpDao dao) {
		this.dao = dao;
	}*/

	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}
}
