package data;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 3812017177088226528L;// pozwala na zachowanie kompatybilnosci wstecznej
	// - po dodaniu nowego pola, bedzie mozna
	// odczytac obiekt stworzony wczesniej
	private String name;
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Person() {}
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + "]";
	}



}
