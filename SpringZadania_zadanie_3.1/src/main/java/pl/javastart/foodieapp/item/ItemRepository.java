package pl.javastart.foodieapp.item;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

	Item findByName(String name);

	Optional<Item> findByNameIgnoreCase(String replaceAll);


}
