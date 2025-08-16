package com.spring.jdbc.noxml;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.spring.jdbc.dao")
public class JdbcConfig {
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("gagan123");
		return ds;
	}

	@Bean(name = { "jdbcTemp" })
	public JdbcTemplate getJdbcTemp() {
		JdbcTemplate jdbcTemp = new JdbcTemplate();
		jdbcTemp.setDataSource(getDataSource());
		return jdbcTemp;
	}

	// Remove this and use @Autowired annotation for dependency injection
	/*
	 * @Bean("studentDao") public StudentDaoImpl getStudentDao() { StudentDaoImpl
	 * studentDao = new StudentDaoImpl(); studentDao.setJdbcTemplate(getJdbcTemp());
	 * return studentDao; }
	 */
}
