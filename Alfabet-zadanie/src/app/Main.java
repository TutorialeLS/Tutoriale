package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<java.lang.Character> array = new ArrayList<>();
		array = Stream.iterate('a', x -> (char) (x + 1))
				.filter(x->x%2!=0)
				.limit(26)
				.collect(Collectors.toList());
		array.forEach(System.out::print);
	}

}
