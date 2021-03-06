package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public SingleConnectionDataSource dataSource() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource());
		return jt;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
}
