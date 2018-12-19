package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		List<Integer> listString = new ArrayList<>(10);
		Map<Integer, String> map = new TreeMap<>();
		map.put(1, "wartosc1");
		map.put(2, "wartosc2");
		map.put(3, "wartosc3");
		Map<Integer, Integer> map1 = new TreeMap<>();
		map1.put(1, 5);
		map1.put(2, 4);
		map1.put(3, 6);
		Map<String, String> map2 = new TreeMap<>();
		map2.put("1", "wartosc1");
		map2.put("2", "wartosc2");
		map2.put("3", "wartosc3");

		printMap(map2, k -> {
			System.out.print(k + " ");
			System.out.println(map2.get(k));
		});
		printMap(map1, k -> {
			System.out.print(k + " ");
			System.out.println(map1.get(k));
		});
		printMap(map, k -> {
			System.out.print(k + " ");
			System.out.println(map.get(k));
		});

	}

	private static <T> void generate(List<T> listString, int size, Supplier<T> supp) {
		for (int i = 0; i < size; i++) {
			listString.add(i, supp.get());

		}

	}

	private static <K, T> void printMap(Map<K, T> map, Consumer<K> consumer) {

		for (K t : map.keySet()) {
			consumer.accept(t);
		}

	}

	private static <T> void printList(List<T> list, Consumer<T> consumer) {
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

	private static <T> void addNextToEach(List<T> list, Function<T, T> func) {
		for (int i = 0; i < list.size() - 1; i++) {
			list.set(i, func.apply(list.get(i + 1)));
		}

	}

	private static <T> void fillEmply(List<T> list, Function<T, T> func) {
		for (int i = 0; i < list.size() - 1; i++) {
			list.set(i, func.apply(list.get(i + 1)));
		}

	}

	private static <T> void fill(List<T> list, int size, Supplier<T> sup) {
		for (int i = 0; i < size; i++) {
			list.add(sup.get());
		}
	}
}
