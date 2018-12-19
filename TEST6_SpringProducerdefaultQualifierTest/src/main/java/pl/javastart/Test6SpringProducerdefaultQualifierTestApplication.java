package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.beans.printers.MessagePrinter;

@SpringBootApplication
public class Test6SpringProducerdefaultQualifierTestApplication {

	public static void main(String[] args) {
		   ConfigurableApplicationContext ctx = SpringApplication.run(Test6SpringProducerdefaultQualifierTestApplication.class, args);
		   MessagePrinter printer = ctx.getBean(MessagePrinter.class);
		printer.print();
		ctx.close();
	}
}
