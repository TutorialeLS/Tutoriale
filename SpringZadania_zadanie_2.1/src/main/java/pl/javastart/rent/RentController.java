package pl.javastart.rent;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import pl.javastart.customer.Customer;
import pl.javastart.customer.CustomerService;
import pl.javastart.device.Device;
import pl.javastart.device.DeviceService;

@Controller
public class RentController {

	private DeviceService deviceService;
	private CustomerService customerService;
	private Scanner scanner;
	
	public RentController(DeviceService deviceService, CustomerService customerService,Scanner scanner) {
		this.deviceService=deviceService;
		this.customerService=customerService;
		this.scanner=scanner;
	}
	
	public void rent(){
		System.out.println("Podaj id urzadzenia do wypozyczenia");
		Device deviceToRent=deviceService.read(readById());
		System.out.println("Podaj pesel uzytkownika");
		//Customer customerRenting=customerService.readById(readById());
		Customer customerRenting=customerService.readByPesel(readByPesel());
		if(deviceToRent.getQuantity()>0) {
			deviceToRent.setQuantity(deviceToRent.getQuantity()-1);				
			deviceToRent.addCustomer(customerRenting);				
			deviceService.update(deviceToRent);
		}else {
			System.out.println("Brak urządzeń do wypożyczenia");
		}
	}
	private Long readById() {
		Long id=scanner.nextLong();
		scanner.nextLine();
		return id;
	}
	private String readByPesel() {
		String pesel=scanner.nextLine();
		return pesel;
	}
}
