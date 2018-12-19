package pl.javastart.beans.decorators;


import org.springframework.stereotype.Component;

import pl.javastart.beans.decorators.Decorator.DecoratorType;

@Component
@Decorator(type = DecoratorType.UPPER)//nie jest konieczne okreslenie typu w momencie wstrzykiwania ze wzgledu na zapis default w 
//definicji kwalifikatora
public class UpperCaseMessageDecorator implements MessageDecorator {

	public String decorate(String msg) {
		return msg.toUpperCase();
	}
}