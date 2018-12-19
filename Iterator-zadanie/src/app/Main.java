package app;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		Map<String, Person> persons=new TreeMap<>();
		Person p1=new Person("Lucjan1", "aSakow1", "20");
		Person p2=new Person("Lucjan2", "cSakowz2", "20");
		Person p3=new Person("Lucjan3", "bSaicz3", "20");
		Person p4=new Person("Lucjan4", "eSawicz4", "20");
		Person p5=new Person("Lucjan5", "dSako5", "20");
		persons.put(p1.getLastName(), p1);
		persons.put(p2.getLastName(), p2);
		persons.put(p1.getLastName(), p3);
		persons.put(p1.getLastName(), p4);
		persons.put(p1.getLastName(), p5);

        Iterator<Person> personsIterator = persons.values().iterator();//zwraca wartosci z mapy persons 
        																//ktore są kolekcją (iterator jest interfejsem kolekcji)
        while (personsIterator.hasNext()) {
        	Person person = personsIterator.next();
            System.out.println(person);
        }
        System.out.println(persons.size());

	}

}
