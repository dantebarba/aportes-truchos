package com.github.dantebarba.aportestruchos.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfiguration {

	@Value("${database.url}" )
	private String url = "jdbc:mysql://localhost:3306/aportes";
	
	@Value("${database.user}")
	private String user = "root";
	
	@Value("${database.password}")
	private String password = "1A2B3C4E";
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.github.dantebarba.aportestruchos.api.domain" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	public DataSourceBuilder getDataSourceBuilder() {
		return DataSourceBuilder.create().url(url).username(user)
				.password(password).driverClassName("com.mysql.jdbc.Driver");
	}
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return this.getDataSourceBuilder().build();
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		hibernateProperties.setProperty("hibernate.use_sql_comments", "false");

		return hibernateProperties;
	}
}
