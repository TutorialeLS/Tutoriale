package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

		   public static void main(String[] args) {
		        Stream<Integer> numStream = Stream.iterate(0, x -> x + 1);
		        // lista kwadratów kolejnych 100 liczb całkowitych
		        List<Integer> squareNumbers = numStream.map(x -> x*x)
		                                                .limit(100)
		                                                .collect(Collectors.toList());
		        //zbiór kwadratów liczb
		        Set<Integer> biggerThan5 = squareNumbers.stream()
		                                                .filter(x -> x%10 ==0)
		                                                .map(x -> x/10)
		                                                .collect(Collectors.toCollection(TreeSet<Integer>::new));
		        
		        Map<Integer,Integer> numMapStream = new HashMap<>();
		        for(int i=0;i<100;i++){
		        	numMapStream.put(i, 2*i);
		        }
		        
		        Map<Integer, Integer> collect = numMapStream.entrySet().stream()
		                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));		
		        
		        System.out.println("List");
		        squareNumbers.forEach(x -> System.out.print(x + " ; "));
		        System.out.println("\nSet");
		        biggerThan5.forEach(x -> System.out.print(x + " ; "));
		        System.out.println("\nMap");
		        System.out.println(collect); 
		    }
}
