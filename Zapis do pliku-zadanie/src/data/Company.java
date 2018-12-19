package data;

import java.io.Serializable;

public class Company implements Serializable {
	public static final int MAX_EMPLOYEES = 3;
	private Employee[] employees;
	private int employeeNumber;

	
	public Company() {// pusty konstruktor z ustawieniem rozmiarów obiektow
		employees = new Employee[MAX_EMPLOYEES];
	}

	public void addEmployee(Employee e) throws ArrayIndexOutOfBoundsException {
		if (employeeNumber == MAX_EMPLOYEES) {
			throw new ArrayIndexOutOfBoundsException("MAX_EMPLOYEES "+MAX_EMPLOYEES);
		}
			employees[employeeNumber] = e;
			employeeNumber++;//trzymanie w programie?

	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<employeeNumber;i++) {
			builder.append(employees[i]);
			builder.append("\n");			
		}
		return builder.toString();
		
	}
}