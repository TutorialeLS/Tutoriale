package pl.javastart.device;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {

	Optional<Device> findByNameContaining(String name);
	Optional<List<Device>> findByNameContainingIgnoreCase(String name);
	Iterable<Device> findAllByNameContainingIgnoreCase(String name);
	
}
