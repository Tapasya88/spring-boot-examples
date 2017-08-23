package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "EMP Saved..";
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> getAllEmps() {
		Query query = em.createQuery("select e from Emp e");
		List<Emp> empList = query.getResultList();
		return empList;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e1 = em.find(Emp.class, id);
		return e1;
	}

}
