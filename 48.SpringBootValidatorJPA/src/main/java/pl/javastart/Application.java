package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.model.Person;
import pl.javastart.service.PersonService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Person person = new Person("Jan", "awd", "zly@Email", 1);
        PersonService personService = ctx.getBean(PersonService.class);
        personService.add(person);
        ctx.close();
    }
}