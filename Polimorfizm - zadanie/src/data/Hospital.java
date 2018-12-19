package data;

public class Hospital {
	private Person[] persons;
	private int personNumber;

	public Person[] getPersons() {
		return persons;
	}

	public void setPersons(Person[] persons) {
		this.persons = persons;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public Hospital() {
		setPersons(new Person[3]);
		setPersonNumber(0);

	}

	public void add(Person person) {
		persons[personNumber] = person;
		personNumber++;
	}

	@Override
	public String toString() {
		String result="";
		for (int i = 0; i < personNumber; i++) {
			result=result+persons[i]+"\n";
		}
		return result;
	}

}
