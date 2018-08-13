package com.evoucher;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@SpringBootApplication
	@Configuration
	@ComponentScan("com.evoucher")
	@EnableAutoConfiguration
	@PropertySource("classpath:application.properties")
	@EnableJpaRepositories("com.evoucher.repository")
	@EntityScan("com.evoucher.model")
public class CreateEvoucherApplication {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(CreateEvoucherApplication.class, args); }
	 */

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan("com.evoucher.model");
		em.setPersistenceUnitName("voucherPersistenceUnit");
		em.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");

		em.setDataSource(dataSource());

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource
				.setUrl("jdbc:mysql://itc.ciu6a2q0dqp7.us-west-2.rds.amazonaws.com/demo?jdbcCompliantTruncation=false");
		dataSource.setUsername("voucher");
		dataSource.setPassword("jay74{craves");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		return properties;
	}
}
