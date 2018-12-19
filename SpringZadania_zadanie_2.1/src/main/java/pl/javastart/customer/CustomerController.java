package pl.javastart.customer;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class CustomerController {

	private CustomerService customerService;
	private Scanner scanner;
	@Autowired
	public CustomerController(CustomerService customerService, Scanner scanner) {
		this.customerService=customerService;
		this.scanner=scanner;
	}
	
	
	public void createCustomer() {
		Customer customer=new Customer();
		customerService.create(readCustomer(customer));
		
	}

	public void removeCustomer() {
		System.out.println("Podaj klienta do usunięcia: ");
		Long id = scanner.nextLong();
		scanner.nextLine();
		customerService.remove(id);
		
	}
	
	public Customer readCustomer(Customer customer) {
	      System.out.println("Podaj imię:");
	        customer.setFirstName(scanner.nextLine());
	        System.out.println("Podaj nazwisko:");
	        customer.setLastName(scanner.nextLine());
	        System.out.println("Podaj pesel:");
	        customer.setPesel(scanner.nextLine());
	        System.out.println("Podaj numer dowodu:");
	        customer.setIdNumber(scanner.nextLine());
	        return customer;
		
	}




}
