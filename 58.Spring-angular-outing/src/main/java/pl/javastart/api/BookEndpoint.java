package pl.javastart.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.javastart.model.Book;
import pl.javastart.repository.BookRepository;

@RestController
public class BookEndpoint {
    
    private BookRepository bookRepository;
    
    @Autowired
    public BookEndpoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //zwraca wszystkie elementy pod wskazanym adresem
    //nie powinno zwrocic JSON zamiast listy?
    @GetMapping("/api/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    
    }
    
    //zwraca ksiazke o wskazanym id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book != null) {
            return ResponseEntity.ok(book.get());
        } else {
        	//powinna byc dodana dodatkowa informacja + wiecej rodzajow bledow?
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/api/books")
    public ResponseEntity<?> save(@RequestBody Book book) {
    	//jezeli bookId jest puste (obiekt o takim Id nie istnieje), tworzy obiekt
        if(book.getId() == null) {
            Book saved = bookRepository.save(book);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getId())
                    .toUri();
            return ResponseEntity.created(location).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } 
    }
}