package pl.javastart.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void remove(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		customer.ifPresent(customerRepository::delete);
	}

	public void create(Customer readCustomer) {
		customerRepository.save(readCustomer);

	}

	public Customer readById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.isPresent() ? customer.get() : null;
	}

	public void update(Customer customerRenting) {
		if (customerRepository.findById(customerRenting.getId()).isPresent()) {
			System.out.println("Zapisuję");
			customerRepository.save(customerRenting);
		}
	}

	public Customer readByPesel(String readByPesel) {
		Optional<Customer> customer = customerRepository.findByPesel(readByPesel);
		return customer.isPresent() ? customer.get() : null;
	}

}
