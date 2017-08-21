package com.demo.spring;

import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {

		return "JDBC: Employee saved with id " + e.getEmpId();
	}

}
