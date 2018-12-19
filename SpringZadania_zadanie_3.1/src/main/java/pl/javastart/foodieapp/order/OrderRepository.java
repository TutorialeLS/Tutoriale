package pl.javastart.foodieapp.order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>{

	List<Order> findAllByStatus(OrderStatus status);

}
