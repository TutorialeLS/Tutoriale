package app;

public class Person implements Comparable<Person> {
	private String name;
	private String surname;
	private Priority priority;

	public enum Priority {
		LOW, MID, HIGH
	}

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

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	Person(String name, String surname, Priority priority) {
		setName(name);
		setSurname(surname);
		setPriority(priority);
	}

	@Override
	public int compareTo(Person o) {
		return priority.compareTo(o.getPriority());
	}

	@Override
	public String toString() {
		return "[ "+"name= " + name + ", surname= " + surname + ", priority= " + priority +" ]"+" \r";
	}
	
}
