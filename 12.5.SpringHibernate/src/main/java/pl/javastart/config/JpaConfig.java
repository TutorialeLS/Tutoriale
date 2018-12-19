package pl.javastart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfig {
    @Bean
    public LocalEntityManagerFactoryBean createEMF() {//posrednik pomiedzy springiem i JPA
    	//umozliwia wstrzykiwanie EntityManager i EntityManagerFactory do roznych repozytoriow
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("spring-jpa-pu");
        return emf;
    }
    //persistence unit -  A persistence unit defines
    //a set of all entity classes that are managed by 
    //EntityManager instances in an application
}