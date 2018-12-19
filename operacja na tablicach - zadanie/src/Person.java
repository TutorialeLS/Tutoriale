
public class Person {
	private String firstName;
	private String lastName;
	private String PESEL;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public void setPESEL(String PESEL) {
		this.PESEL = PESEL;
	}
	public Person(String firstName, String lastName, String PESEL) {
		setFirstName(firstName);
		setLastName(lastName);
		setPESEL(PESEL);
	
	
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", PESEL=" + PESEL + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PESEL == null) ? 0 : PESEL.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (PESEL == null) {
			if (other.PESEL != null)
				return false;
		} else if (!PESEL.equals(other.PESEL))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}
