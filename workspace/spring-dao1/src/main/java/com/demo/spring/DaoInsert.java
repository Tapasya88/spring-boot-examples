package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.demo.spring.config.AppConfig;

public class DaoInsert {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jt = (JdbcTemplate) ctx.getBean("jdbcTemplate");

		int rowCount = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) values (?,?,?,?)");
				pst.setInt(1, 200);
				pst.setString(2, "Raju");
				pst.setString(3, "Bangalore");
				pst.setDouble(4, 40000);
				return pst;
			}
			
		});

		System.out.println("Rows Inserted : "+rowCount);
	}

}
