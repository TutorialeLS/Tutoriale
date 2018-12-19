package data;

//Patient - klasa przechowująca dane o pacjencie (imię, nazwisko, PESEL) - klasa powinna być zgodna z konwencją JavaBeans
public class Patient {
	private String name;
	private String lastName;
	private String PESEL;


	public Patient(){
		
	}
	Patient(String name, String lastName, String PESEL){
		this.setName(name);
		this.setLastName(lastName);
		this.setPESEL(PESEL);
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPESEL() {
		return PESEL;
	}
	public void setPESEL(String string) {
		this.PESEL=string;
	}


}
