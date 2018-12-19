package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Main implements Comparable<String> {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("namespl.txt"));

		TreeSet<String> names = new TreeSet<>(new NameComparator());// pobieranie do zbioru z automatycznym sortowaniem
		String name;
		while ((name = reader.readLine()) != null) {
			names.add(name);
		}
		reader.close();
		System.out.println("Ilość imion w zbiorze: " + names.size());
		System.out.println("Pierwsze imię: " + names.first());
		System.out.println("Ostatnie imię w zbiorze: " + names.last());
		
		BufferedReader reader1 = new BufferedReader(new FileReader("namespl.txt"));
		TreeSet<String> names1 = new TreeSet<>(new LengthComparator());// pobieranie do zbioru z automatycznym sortowaniem
		String name1;
		while ((name1 = reader1.readLine()) != null) {
			names1.add(name1);
		}
		reader1.close();
		System.out.println("Ilość imion w zbiorze: " + names1.size());
		System.out.println("Pierwsze imię: " + names1.first());
		System.out.println("Ostatnie imię w zbiorze: " + names1.last());
		
		
		
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class NameComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return -o1.compareTo(o2);
		}
	}
	
	public static class LengthComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			Integer a=o1.split("").length;
        	Integer b=o2.split("").length;
            return -a.compareTo(b);
		}
	}

}