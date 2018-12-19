package app;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
	public static void main(String[] args) {
		Stream<Integer> numStream = Stream.iterate(0, x -> x + 1);
		int option = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj liczbe");
		option = sc.nextInt();
		switch (option) {

		case 0:
			List<Integer> numbers = numStream.filter(x -> x % 2 == 0).limit(100).collect(Collectors.toList());
			numbers.forEach(x -> System.out.print(x+" ; "));
			break;
		case 1:
			List<Integer> squareNumbers = numStream.map(x -> x * x).limit(100).collect(Collectors.toList());
			squareNumbers.forEach(x -> System.out.print(x+" ; "));
			break;
		case 2:
			List<Integer> negativeNumbers = numStream.map(x -> -x).limit(100).collect(Collectors.toList());
			negativeNumbers.forEach(x -> System.out.print(x+" ; "));
			break;

		}
		
	}
}
