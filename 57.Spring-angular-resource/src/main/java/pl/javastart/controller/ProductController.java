package pl.javastart.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.javastart.model.Product;
import pl.javastart.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //pobiera listę wszystkich produktów i zwraca je w odpowiedzi z kodem 200 OK
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }
    //zwraca pojedynczy produkt na podstawie id znajdującego się w adresie URL
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return ResponseEntity.ok(product.get());
    }
    // służy do zapisania informacji o nowym produkcie. W odpowiedzi wysyłamy
    // nagłówek z ustawioną lokalizacją utworzonego zasobu oraz utworzony obiekt (z ustawionym id)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        Product save = productRepository.save(product);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(location).body(save);
    }
}