package pl.javastart.beans.decorators;


import org.springframework.stereotype.Component;

import pl.javastart.beans.decorators.Decorator.DecoratorType;

@Component
@Decorator(type = DecoratorType.UPPER)
public class UpperCaseMessageDecorator implements MessageDecorator {

	public String decorate(String msg) {
		return msg.toUpperCase();
	}
}