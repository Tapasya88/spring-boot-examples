package com.demo.spring;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, String>{

	@Query(name="getAllUsers",value="select u from User u")
	public List<User> getAll();
}
