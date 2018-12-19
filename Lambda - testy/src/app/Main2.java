package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
	public static void main(String[] args) {
		List<Integer> listString = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		Stream<Integer> streamListString = listString.stream().filter(p -> p % 2 == 0);
		//streamListString.map(p -> p % 2 == 0);
		streamListString.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(streamListString.getClass());
	}


}