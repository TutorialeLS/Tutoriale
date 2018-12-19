package pl.javastart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.ClientDao;
import pl.javastart.dao.OrderDao;
import pl.javastart.model.Client;
import pl.javastart.model.Order;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
        
        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        Order order = new Order("Telewizor LG", "42', dostawa do domu");
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        order.setClient(client);
        orderDao.save(order);
        
      //  client.setOrders(orders);
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);
        System.out.println(client);
        
      
      
        
        ctx.close();
    }
}