package pl.javastart.beans.producers;
import pl.javastart.beans.producers.Producer.ProducerType;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Producer(type = ProducerType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}
}