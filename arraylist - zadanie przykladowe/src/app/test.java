package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		List<Object> arr = new ArrayList<>();

		try (Scanner sc = new Scanner(System.in);) {
			counter(arr, sc);
		}
		printArray(arr);
		
	}

	

	public static void counter(List<Object> tab, Scanner sc) {

		System.out.println("Podaj liczbę do dodania (0 kończy program)");
		try{
			int a = sc.nextInt();
		if (a == 0) {
			System.out.println("Wybrano 0");
			return;
		} else {
			System.out.println("Podano liczbę: " + a);
			tab.add(a);
			System.out.println("**************************");
		}
		counter(tab, sc);
		}catch(InputMismatchException e) {
			sc.nextLine();
			System.out.println("Podana wartość nie jest liczba, spróbuj ponownie");
			counter(tab, sc);
			
		}
	}

	public static void printArray(List<Object> tab) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		System.out.println("Wynik: ");
		for (int i = 0; i < tab.size() - 1; i++) {
			sb.append(tab.get(i));
			sb.append(" + ");
			sum = (int)sum + (int)tab.get(i);
		}
		sb.append(tab.get(tab.size() - 1));
		sum = (int)sum + (int)tab.get(tab.size() - 1);
		System.out.println(sb.toString());
		System.out.println("to: " + sum);
	}
}
