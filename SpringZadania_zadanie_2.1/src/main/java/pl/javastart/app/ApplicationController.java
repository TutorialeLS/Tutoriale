package pl.javastart.app;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pl.javastart.category.CategoryController;
import pl.javastart.customer.CustomerController;
import pl.javastart.device.DeviceController;
import pl.javastart.rent.RentController;


@Controller
public class ApplicationController {

    private Scanner scanner;
    private DeviceController deviceController;
    private CategoryController categoryController;
    private CustomerController customerController;
    private RentController rentController;
    
    @Autowired
    public ApplicationController(Scanner scanner, DeviceController deviceController, CategoryController categoryController,
                                 CustomerController customerController, RentController rentController) {
        this.scanner = scanner;
        this.deviceController = deviceController;
        this.categoryController = categoryController;
        this.customerController = customerController;
        this.rentController = rentController;
    }

    public void mainLoop() {
        Options option;
        do {
            printOptions();
            option = readOption();
            executeOption(option);
        } while(option != Options.EXIT);
    }

    private void printOptions() {
        System.out.println("Opcje:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }

    private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while(!correctOptionSelected) {
            System.out.println("Podaj ID opcji:");
            int optionId = scanner.nextInt();
            scanner.nextLine();
            try {
                option = Options.numberToCategory(optionId);
                correctOptionSelected = true;
            } catch(InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(Options option) {
        switch (option) {
            case ADD_DEVICE:
                deviceController.createDevice();
                break;
            case ADD_CATEGORY:
                categoryController.createCategory();
                break;
            case ADD_CUSTOMER:
                customerController.createCustomer();
                break;
            case RENT:
                rentController.rent();
                break;
            case REMOVE_DEVICE:
                deviceController.removeDevice();
                break;
            case REMOVE_CATEGORY:
                categoryController.removeCategory();
                break;
            case REMOVE_CUSTOMER:
                customerController.removeCustomer();
                break;
            case SEARCH:
            	deviceController.searchDeviceByName();
            	break;
            case EXIT:
                closeApp();
        }
    }

    private void closeApp() {
        scanner.close();
        System.out.println("Bye bye!");
    }
}