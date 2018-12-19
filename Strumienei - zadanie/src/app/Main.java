package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Main {
    public static void main(String[] args) {
//        List<Integer> numbers = Stream.iterate(0, x -> x+1)
//                                    .filter(x -> x>100)
//                                    .filter(x->x<1000)
//                                    .filter(x->x%5 ==0)
//                                    .limit(10)
//                                    .map(x -> x*3)
//                                    .peek(System.out::println)
//                                    .collect(Collectors.toList());
//        
//        
//        String letters=Stream.iterate("0",x->x+"1")
//        						.limit(10)
//        						.collect(Collectors.joining());
//        System.out.println(letters);
//        System.out.println(numbers.getClass());
//        numbers.forEach(System.out::println);
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers2 = Arrays.asList(12, 14, 16, 18, 20, 22, 24, 26, 28, 30);
        numbers1 = numbers1.stream()
                        .filter(x -> x%2 == 0 && x>5)
                        .addNumberToStream(Arrays.asList(1,2,3,4,5))
                        .collect(Collectors.toCollection(ArrayList::new));
        numbers1.forEach(System.out::println);
    }
    
    
    
    private static Stream<Integer> addNumberToStream(List<Integer> list){
    	
		return null;
    	
    }
}