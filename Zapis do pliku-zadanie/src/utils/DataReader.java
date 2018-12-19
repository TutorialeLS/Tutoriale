package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Employee;


public class DataReader {
	public static final String FILE_STORE = "Miska.info";
	private Scanner sc;
	private DataSaver dataSaver;

	public DataReader() {
		dataSaver = new DataSaver();
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}


    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie");
        } finally {
            sc.nextLine();
        }
        return number;
    }
 
    public void createEmployee() throws InputMismatchException {
        System.out.println("Podaj imię pracownika: ");
        String name = sc.nextLine();
        System.out.println("Podaj nazwisko pracownika: ");
        String surname = sc.nextLine();
        int salary=0;
        try {
        	System.out.println("Podaj wypłatę pracownika: ");
            salary = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }
        dataSaver.saveEmployee(new Employee(name, surname, salary));
    }
 
}