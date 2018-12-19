package pl.javastart.device;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pl.javastart.category.Category;
import pl.javastart.category.CategoryService;

@Controller
public class DeviceController {

	private DeviceService deviceService;
	private CategoryService categoryService;
	private Scanner scanner;
	
	@Autowired
	public DeviceController(DeviceService deviceService, Scanner scanner, CategoryService categoryService) {
		this.deviceService = deviceService;
		this.scanner=scanner;
		this.categoryService=categoryService;
	}

	public void createDevice() {
		Device device=new Device();
		deviceService.create(readDevice(device));
		

	}

	public void removeDevice() {
		System.out.println("Podaj urządzenie do usunięcia: ");
		Long id = scanner.nextLong();
		scanner.nextLine();
		deviceService.remove(id);

	}

	private Device readDevice(Device device) {
	        System.out.println("Nazwa urządzenia:");
	        device.setName(scanner.nextLine());
	        System.out.println("Opis urządzenia:");
	        device.setDescription(scanner.nextLine());
	        System.out.println("Cena urządzenia:");
	        device.setPrice(scanner.nextDouble());
	        System.out.println("Ilość(szt) urządzenia:");
	        device.setQuantity(scanner.nextInt());
	        scanner.nextLine();
	        System.out.println("Nazwa kategorii: ");
	        String categoryName=scanner.nextLine();
	      //  long categoryId = scanner.nextLong();
	        Optional<Category> category=categoryService.readByName(categoryName);
	       // Optional<Category> category = categoryService.findById(categoryId);
	       // scanner.nextLine();
	        category.ifPresent(device::setCategory);
	        return device;
	}

		public void searchDeviceByName() {
			System.out.println("Podaj nazwe urzadzenia do wyszukania: ");
			String name=scanner.nextLine();
			Optional<List<Device>> devices=deviceService.search(name);
			System.out.println("Wyszukane urządzenia: ");
			for(Device d:devices.get()) {
				System.out.println(d);
			}
		}
	
}
