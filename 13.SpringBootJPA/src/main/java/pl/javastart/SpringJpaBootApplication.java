package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaBootApplication.class, args);
        BookDao dao = ctx.getBean(BookDao.class);
        Book book = new Book("123", "Spring is so cool", "Javastart");
        dao.save(book);
        System.out.println("OK");
    }
}