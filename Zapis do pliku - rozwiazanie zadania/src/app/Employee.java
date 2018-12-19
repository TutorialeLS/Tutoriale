package app;

public class Employee extends Person {
	 
    private static final long serialVersionUID = 4420226460862818754L;
 
    private double salary;
 
    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
     
    public Employee(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        setSalary(salary);
    }
     
    @Override
    public String toString() {
        return super.toString() + ", wypłata " + salary;
    }
}