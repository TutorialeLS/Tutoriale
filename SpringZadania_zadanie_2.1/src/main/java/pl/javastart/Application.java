package pl.javastart;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import pl.javastart.app.ApplicationController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ApplicationController appController=ctx.getBean(ApplicationController.class);
		appController.mainLoop();
		ctx.close();
	}
	@SuppressWarnings("resource")
	@Bean
	Scanner scanner() {
		return new Scanner(System.in).useLocale(Locale.US);
	}
}
