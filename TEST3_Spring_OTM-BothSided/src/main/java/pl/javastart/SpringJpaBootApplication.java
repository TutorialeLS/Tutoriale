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
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);        
        Order order = new Order("Telewizor LG", "42', dostawa do domu");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);
//        Client client2=clientDao.get(1L);
//        System.out.println(client2.getOrders().toString());
//        Order order2=orderDao.get(1L);
//        System.out.println(order2.getClient());
        ctx.close();
    }
}