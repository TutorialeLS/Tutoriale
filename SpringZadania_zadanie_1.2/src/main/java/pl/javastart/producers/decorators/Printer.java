package pl.javastart.producers.decorators;

import org.springframework.stereotype.Component;

import pl.javastart.producers.decorators.DecoratorType.DecoratorVersion;

@Component
public class Printer {
	private Decorator decorator;

	public Printer(@DecoratorType(type=DecoratorVersion.UPPER)Decorator decorator) {
		this.decorator = decorator;
	}
	public void println(String str) {
		String output=decorator.decorate(str);
		System.out.println(output);
	}
}
