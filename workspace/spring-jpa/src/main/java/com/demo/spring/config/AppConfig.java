package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.demo.spring");

		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setShowSql(true);
		va.setDatabase(Database.MYSQL);

		emf.setJpaVendorAdapter(va);

		return emf;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setEntityManagerFactory(entityManagerFactory().getObject());
		return tx;
	}
}
