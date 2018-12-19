package pl.javastart.beans;


import org.springframework.stereotype.Component;

import pl.javastart.beans.Decorator.DecoratorType;

@Component
@Decorator(type = DecoratorType.UPPER)
public class UpperCaseMessageDecorator implements MessageDecorator {

	public String decorate(String msg) {
		return msg.toUpperCase();
	}
}