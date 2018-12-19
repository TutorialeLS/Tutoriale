package app;

import java.util.HashSet;
 
public class PersonSet {
    public static void main(String[] args) {
        HashSet<Person> persons = new HashSet<>();
        HashSet<Person> persons2 = new HashSet<>();
        persons.add(new Person("Jan", "Kowalski"));
        persons.add(new Person("Jan3", "Kowalski"));
        persons.add(new Person("Ani1a", "Kawalec"));
        persons.add(new Person("Ania", "Kawalec"));
        persons.add(new Person("Szymon", "Zalewski"));
        
        System.out.println("Persons.size() " + persons.size());
        System.out.println("contains Jan Kowalski? " + persons.contains(new Person("Jan", "Kowalski")));
       persons.remove(new Person("Ania", "Kawalec"));
        System.out.println("Persons.size() " + persons.size());
        for(Person a:persons) {
        	System.out.println(a.toString());
        }
        System.out.println("***************************");
        for(Person a:persons) {
        	System.out.println(a.toString());
        }
        System.out.println("***************************");
        for(Person a:persons) {
        	System.out.println(a.toString());
        }
        System.out.println("***************************");
    }
}