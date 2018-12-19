package app;

import java.util.HashMap;

public class Company {
	private HashMap<String, Employee> employees;

	Company() {
		employees = new HashMap<>();
	}

	public boolean addEmployee(Employee e) {
		String key = e.getFirstName() + " " + e.getLastName();
		if(employees.get(key)!=null) {
			return false;
		} else {
			employees.put(key, e);
			return true;
		}
	}

	public Employee getEmployee(String firstName, String lastName) {
		String key = firstName + " " + lastName;
		return employees.get(key);
	}

}
