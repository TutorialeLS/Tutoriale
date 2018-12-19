package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Company;
import data.Employee;
import utils.DataPrinter;
import utils.DataReader;
import utils.DataSaver;

public class CompanyControl {
	public static final String FILE_STORE = "employees.txt";
	// komunikacja z uzytkownikiem
	private DataReader dataReader;
	private DataPrinter dataPrinter;
	// dane
	private Company company;

	public CompanyControl() {//domyslny konstruktor 
		dataReader = new DataReader();
		dataPrinter = new DataPrinter();
		company = new Company();
	}
	
	 public void controlLoop() throws InputMismatchException, NumberFormatException, NoSuchElementException, FileNotFoundException, ClassNotFoundException, IOException {
	        Option option = null;
	        while (option != Option.EXIT) {
	            try {
	                printOptions();
	                option = Option.createFromInt(dataReader.getInt());
	                switch (option) {
	                case ADD_EMPLOYEE:
	                    addEmployee();
	                    break;
	                case READ_EMPLOYEE:
	                    readEmployee();
	                    break;
	                case EXIT:
	                    ;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Wprowadzono niepoprawne dane, nie dodano pracownika");
	            } catch (NumberFormatException e) {
	            	System.out.println("Wybrany pracownik nie istnieje, wybierz ponownie:");
	            }catch (NoSuchElementException e) {
	                System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
	            }
	        }
	        // zamykamy strumień wejścia
	        dataReader.close();
	    }
	  
	    private void printOptions() {
	        System.out.println("Wybierz opcję: ");
	        for (Option o : Option.values()) {
	            System.out.println(o);
	        }
	    }
	  
	    private void addEmployee() {
	        dataReader.createEmployee();
	    }
	  
	  
	    private void readEmployee() throws FileNotFoundException, ClassNotFoundException, IOException {
	    	System.out.println(dataPrinter.readEmployee());
	       
	    }
	  

	    private enum Option {
	    	EXIT(0,"Wyjscie z programu"),
	    	ADD_EMPLOYEE(1,"Dodanie pracownika"),
	    	READ_EMPLOYEE(2,"Wczytanie pracownika");

	    	
	    	private int value;
	    	private String description;

	    	Option(int value, String desc){
	    		this.value=value;
	    		this.description=desc;
	    	}
	    	@Override
	    	public String toString() {
	    	return value+" - "+description;
	    	}
	    	public static Option createFromInt(int option) throws NoSuchElementException {
	    	      Option result = null;
	    	        try {
	    	            result = Option.values()[option];
	    	        } catch(ArrayIndexOutOfBoundsException e) {
	    	            throw new NoSuchElementException("Brak elementu o wskazanym ID");
	    	        }
	    	         
	    	        return result;
	    	}
	    }
	}