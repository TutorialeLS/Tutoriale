package com.library;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class Securitytest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Securitytest1Application.class, args);
		ConfigurableApplicationContext ctx = 
		        SpringApplication.run(Securitytest1Application.class, args);
//		Locale.setDefault(Locale.GERMAN);
		Validator validator = ctx.getBean(Validator.class);
		
		Number numBean= new Number(2);
		//to powinno byc w serwisie
		Set<ConstraintViolation<Number>> errors = validator.validate(numBean);
		errors.forEach(err -> System.err.println(err.getMessage()));
		
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
