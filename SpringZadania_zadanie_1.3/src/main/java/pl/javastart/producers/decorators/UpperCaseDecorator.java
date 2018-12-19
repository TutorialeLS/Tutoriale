package pl.javastart.producers.decorators;


import org.springframework.stereotype.Component;

import pl.javastart.producers.decorators.DecoratorType.DecoratorVersion;

@Component
@DecoratorType(type=DecoratorVersion.UPPER)
public class UpperCaseDecorator implements Decorator {

	@Override
	public String decorate(String str) {
		return str.toUpperCase();
	}

}
