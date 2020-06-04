package com.jbk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jbk.hibernate.Employee;



@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.jbk.hibernate")
public class Springbootconfig {

	
	@Autowired
	private ApplicationContext context;

	 
	@Bean
	public LocalSessionFactoryBean getSessionFactory()  
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(Employee.class);
		return factoryBean;
	}
}


