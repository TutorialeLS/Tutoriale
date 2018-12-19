package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import pl.javastart.beans.Decorator.DecoratorType;
import pl.javastart.beans.Message.MessageType;

@Component
public class MessagePrinter {
	
	private MessageProducer producer;
	private MessageDecorator decorator;
	
	@Autowired
	public MessagePrinter(@Message(type=MessageType.SIMPLE)MessageProducer producer) {
		this.producer = producer;
	}

	public MessageDecorator getDecorator() {
		return decorator;
	}

	@Autowired(required = false)
	public void setDecorator(@Decorator(type=DecoratorType.LOWER)MessageDecorator decorator) {
		this.decorator = decorator;
	}

	public void print() {
		String message = producer.getMessage();
		message = decorator != null? decorator.decorate(message) : message;
		System.out.println(message);
	}
}