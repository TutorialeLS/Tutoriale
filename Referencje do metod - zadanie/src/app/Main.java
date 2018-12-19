package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		List<String> nameList= new ArrayList<>();
		nameList.add("Lucjan");
		nameList.add("Misia");
		nameList.add("Adam");
		nameList.add("Zosia");
		nameList.add("Katarzyna");

		
		Collections.shuffle(nameList);
		consumeArray(nameList,System.out::println);
		Collections.sort(nameList, String::compareToIgnoreCase);	
		consumeArray(nameList,System.out::println);
		consumeArray(nameList,x->System.out.println(x));
//		Collections.sort(nameList, new Comparator<String>() {
//		    @Override
//		    public int compare(String o1, String o2) {
//		        return -o1.compareTo(o2);
//		    }
//		}); - inna wersja, comparator w psotaci anonimowej klasy, niezwiazane z trescia zadania
	}
    private static <T> void consumeArray(List<T> arr, Consumer<T> consumer) {
        for (T t : arr) {
            consumer.accept(t);
        }
    }


}
