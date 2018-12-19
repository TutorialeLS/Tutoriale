package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import pl.javastart.model.Book;

@Repository//zastepuje component, domyslnie singleton
public class BookDaoImpl implements BookDao {

    @PersistenceUnit // wstrzykniecie EntityManagerFactory zamiast tworzenia nowego,
    // jest to domyslnie singleton, mozna uzyc te� @Autowired
    private EntityManagerFactory emFactory;

    BookDaoImpl() {
    }

    @Override
    public void save(Book book) {
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        entityManager.close();
    }

    @Override
    public Book get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
}