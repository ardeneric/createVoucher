package com.evoucher;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@SpringBootApplication
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class CreateEvoucherApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(CreateEvoucherApplication.class, args);
	}*/
	
	@Autowired
	Environment environment;

	private final String URL = "dbc:mysql://itc.ciu6a2q0dqp7.us-west-2.rds.amazonaws.com/demo?jdbcCompliantTruncation=false";
	private final String USER = "voucher";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String PASSWORD = "jay74{craves";

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
}
