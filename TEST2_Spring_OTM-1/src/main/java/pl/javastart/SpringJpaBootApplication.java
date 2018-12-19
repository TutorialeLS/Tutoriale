package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.*;
import pl.javastart.model.*;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
        
        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        Order order = new Order("Telewizor LG", "42', dostawa do domu");
        Order order1 = new Order("Telewizor LG", "42', dostawa do domu12312313123");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        client.getOrders().add(order);
        client.getOrders().add(order1);
        orderDao.saveList(client.getOrders());
        client.setOrders(client.getOrders());
        clientDao.save(client); 
        Client clien2=clientDao.get(1L);
        System.out.println(clien2);
        
        ctx.close();
    }
}