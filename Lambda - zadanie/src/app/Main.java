package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Random rand = new Random();

		generate(numbers, () -> rand.nextInt(10));
		
		consumeList(numbers, n -> System.out.println(n));
		filterList(numbers, n->n%2==0);
		
	}

	private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}

	private static <T> void filterByPredicate(List<T> list, Predicate<T> pre) {
		for (T t : list) {
			if (pre.test(t)) {
				System.out.println(t);
			}
		}

	}

	private static <T> void generate(List<T> list, Supplier<T> sup) {
		for (int i = 0; i < 10; i++) {
			list.add(sup.get());
		}
	}

	private static <T> void filterList(List<T> list, Predicate<T> pred) {
		Iterator<T> it = list.iterator();
		while (it.hasNext()) {
			T tmp = it.next();
			if (pred.test(tmp)) {
				it.remove();
			}
		}
	}
}
