package app;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
	 public static void main(String[] args) {
		  Stream<Integer> numStream = Stream.iterate(0, x -> x + 1);
	        // lista kwadratów kolejnych 100 liczb całkowitych
	        List<Integer> squareNumbers = numStream.map(x -> x*x)
	                                                .limit(100)
	                                                .collect(Collectors.toList()); 
	        System.out.println(squareNumbers.getClass());
	 }
}
