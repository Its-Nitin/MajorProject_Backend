package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


@SpringBootApplication(scanBasePackages = "com.springboot.demo")
@ComponentScan(basePackages = "com.springboot.demo")
public class StudentSkillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSkillsApplication.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean SessionFactory() {
		
		return new  HibernateJpaSessionFactoryBean();
	}
	
}
