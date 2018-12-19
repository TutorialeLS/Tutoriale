import java.util.Arrays;

public class PersonDatabase {
	public static int INIT_SIZE =1;
	private Person[] persons;
	private int emptyPlace;
	
	public Person[] getPersons() {
		return persons;
	}

	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
	
	PersonDatabase(){
		persons= new Person[INIT_SIZE];
		emptyPlace=0;
	}
	
	
	

    public void add(Person p) {
        if (emptyPlace == persons.length) {
            persons = Arrays.copyOf(persons, persons.length * 2);
        }
        persons[emptyPlace] = p;
        emptyPlace++;
    }
	
    public void remove(Person p) {
        if (p == null)
            return;
 
        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < persons.length && found == NOT_FOUND) {
            if (p.equals(persons[i])) {
                found = i;
            } else {
                i++;
            }
        }
 
        if (found != NOT_FOUND) {
            System.arraycopy(persons, found + 1, persons, found, persons.length - found - 1);
            emptyPlace--;
        }
    }
	public Person get(int index) {			
		return persons[index];		
	}
	public void size() {
		int i=0;
		for(Person o:persons) {	
			System.out.println(o);
			i++;
		}
	System.out.println("Rozmiar tablicy to: "+i);
	System.out.println("******************************");
	}

	@Override
	public String toString() {
		return "PersonDatabase [persons=" + Arrays.toString(persons) + ", emptyPlace=" + emptyPlace + "]";
	}
	
	
	
}
