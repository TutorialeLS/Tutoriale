package data;

public class Employee extends Person{
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String name, String surname, int salary) {
		super(name, surname);
		setSalary(salary);
	}

	@Override
	public String toString() {
		return "getSalary()=" + getSalary() + ", getName()=" + getName()
				+ ", getSurname()=" + getSurname();
	}
	
}
