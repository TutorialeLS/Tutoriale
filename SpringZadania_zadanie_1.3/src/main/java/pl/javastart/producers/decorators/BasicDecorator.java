package pl.javastart.producers.decorators;

import org.springframework.stereotype.Component;

import pl.javastart.producers.decorators.DecoratorType.DecoratorVersion;

@Component
@DecoratorType(type=DecoratorVersion.BASIC)
public class BasicDecorator implements Decorator {

	@Override
	public String decorate(String str) {
		return str;

	}

}
