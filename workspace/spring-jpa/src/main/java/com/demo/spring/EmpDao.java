package com.demo.spring;

import java.util.List;

public interface EmpDao {
	public String save(Emp e);

	public List<Emp> getAllEmps();

	public String delete(int id);
	public Emp findById(int id);
}
