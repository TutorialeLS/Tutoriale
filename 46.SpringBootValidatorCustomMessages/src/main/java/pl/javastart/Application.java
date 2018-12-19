package pl.javastart;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import pl.javastart.model.NumberBean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
		        SpringApplication.run(Application.class, args);
//		Locale.setDefault(Locale.GERMAN);
		Validator validator = ctx.getBean(Validator.class);
		NumberBean numBean = new NumberBean(4);
		Set<ConstraintViolation<NumberBean>> errors = validator.validate(numBean);
		errors.forEach(err -> System.err.println(err.getMessage()));
	}
	
	@Bean
	public Validator validator() {
	    return new LocalValidatorFactoryBean();
	}
}