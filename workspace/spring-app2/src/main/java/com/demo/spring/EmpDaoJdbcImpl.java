package com.demo.spring;

public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {

		return "JDBC: Employee saved with id " + e.getEmpId();
	}

}
