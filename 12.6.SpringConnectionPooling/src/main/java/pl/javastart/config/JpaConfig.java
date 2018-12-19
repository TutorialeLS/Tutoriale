package pl.javastart.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {
    @Bean // dlaczego kiedy tworze drugie takie same ziarno z adnotacja primary, spring uzywa obu?
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
    	System.out.println("EMF");
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/librarytest?useSSL=false&serverTimezone=UTC");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "root");
        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setJpaPropertyMap(properties);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.javastart.model");
        return emf;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }
}