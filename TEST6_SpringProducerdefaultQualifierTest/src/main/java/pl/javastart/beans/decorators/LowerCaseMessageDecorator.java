package pl.javastart.beans.decorators;
import pl.javastart.beans.decorators.Decorator.DecoratorType;


import org.springframework.stereotype.Component;

@Component
@Decorator(type = DecoratorType.LOWER)
public class LowerCaseMessageDecorator implements MessageDecorator {

	public String decorate(String msg) {
		return msg.toLowerCase();
	}
}