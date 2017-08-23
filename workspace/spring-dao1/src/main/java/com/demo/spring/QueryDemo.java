package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.config.AppConfig;

public class QueryDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}

		});
		
		for(Emp e:empList){
			System.out.println(e.getName());
		}
		
		Emp e=jt.queryForObject("select * from emp where empno="+102, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		});
		
		System.out.println(e.getName()+" "+e.getSalary());

	}

}
