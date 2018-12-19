package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("namespl.txt"));
         
       TreeSet<String> names = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	Integer a=o1.split("").length;
            	Integer b=o2.split("").length;
                return -a.compareTo(b);
            }
        });//pobieranie do zbioru z automatycznym sortowaniem
       
       
        String name;
        while ((name = reader.readLine()) != null) {
            names.add(name);
        }
        reader.close();
         
        System.out.println("Ilość imion w zbiorze: " + names.size());
        System.out.println("Pierwsze imię: " + names.first());
        System.out.println("Ostatnie imię w zbiorze: " + names.last());
        for(String s:names) {
        	System.out.println(s);
        }
    }
}