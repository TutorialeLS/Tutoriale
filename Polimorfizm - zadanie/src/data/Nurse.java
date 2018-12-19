package data;

public class Nurse extends Person{
	private int overtime;

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	public Nurse(String firstName, String lastName, int salary, int overtime){
		super(firstName, lastName,salary);
		setOvertime(overtime);
	}

	@Override
	public String toString() {
		
		return super.toString()+ "Nurse [overtime=" + overtime + "]";
	}
	
}
