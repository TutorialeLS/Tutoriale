package pl.javastart;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import pl.javastart.controller.LinguController;
@PropertySource("classpath:appConfig.properties")
@SpringBootApplication
public class LinguApp {
	public static void main(String args[]) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LinguApp.class, args);

		LinguController controller = ctx.getBean(LinguController.class);
		controller.mainLoop();
		ctx.close();
	}

	@Bean//bean konfiguracyjny, poniewaz @SpringBootApplication zawiera w sobei adnotacje @Configuration
	public Scanner getScanner() {
		return new Scanner(System.in);
	}

}
