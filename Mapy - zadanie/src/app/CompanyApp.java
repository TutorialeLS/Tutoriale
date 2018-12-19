package app;

import java.util.Scanner;
 
public class CompanyApp {
 
    public static final int ADD_EMPLOYEE = 0;
    public static final int FIND_EMPLOYEE = 1;
    public static final int EXIT = 2;
 
    private Company company;
 
    CompanyApp() {
        company = new Company();
    }
 
    public static void main(String[] args) {
        CompanyApp companyApp = new CompanyApp();
        try (Scanner sc = new Scanner(System.in);) {
            int userOption;
            do {
                companyApp.printOptions();
                userOption = sc.nextInt();
                sc.nextLine();
                 
                switch(userOption) {
                case CompanyApp.ADD_EMPLOYEE:
                    companyApp.addEmployee(sc);
                    break;
                case CompanyApp.FIND_EMPLOYEE:
                    companyApp.findAndPrintEmployee(sc);
                    break;
                case CompanyApp.EXIT:
                    break;
                }
            } while (userOption != CompanyApp.EXIT);
        }
    }
     
    private void printOptions() {
        System.out.println("0 - dodanie pracownika");
        System.out.println("1 - wyszukiwanie pracownika");
        System.out.println("2 - Wyjście z programu");
    }
 
    private void addEmployee(Scanner sc) {
        Employee employee = new Employee();//tworze pusty obiekt, pozniej dodaje wartosci przez Set'y
 
        System.out.println("Dodawanie pracownika.");
        System.out.println("Imię: ");
        employee.setFirstName(sc.nextLine());
        System.out.println("Nazwisko: ");
        employee.setLastName(sc.nextLine());
        System.out.println("Pensja: ");
        employee.setSalary(sc.nextDouble());
        sc.nextLine();
         
        company.addEmployee(employee);
 
    }
 
    private void findAndPrintEmployee(Scanner sc) {
        System.out.println("Wyszukiwanie pracownika.");
        System.out.println("Podaj imię: ");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko: ");
        String lastName = sc.nextLine();
 
        Employee employee = company.getEmployee(firstName, lastName);
        System.out.println(employee);
    }
}