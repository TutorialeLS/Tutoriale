package pl.javastart.foodieapp.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


	Optional<Item> findByNameIgnoreCase(String replaceAll);
}