package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.javastart.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional//otwiera i zamyka transakcje
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional(readOnly = true) //spring nie wymaga tej adnotacji, poniewaz hiebrnate nie uzywa 
    //transakcji do wyszukiwania obiektow w bazie danych
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

	@Override
	@Transactional
	public void update(Book book) {
		 entityManager.merge(book);//odpytuje baze danych sprawzdajac czy dany obiekt istnieje
		 //jesli tak - podmienia je
		 //jesli nie - tworzy nowy obiekt
	}

	@Transactional
	public void update2(Book book) {
	    //wyszukujemy obiekt w bazie
	    Book find = entityManager.find(Book.class, book.getId());
	    //sprawdzenie czy istnieje - jesli nie, zwroci null, jesli tak - podmieni parametry na 
	    //te z argumentu metody
	    if(find != null) {
	        find.setTitle(book.getTitle());
	        find.setIsbn(book.getIsbn());
	        find.setAuthor(book.getAuthor());
	    }
	}
	@Override
	@Transactional
	public void remove(Long bookId) {
	    Book objToRemove = entityManager.find(Book.class, bookId);
	    entityManager.remove(objToRemove);
	}
}