package app;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Podaj pierwszą liczbę");
		double firstNumber=scan.nextDouble();
		scan.nextLine();
		System.out.println("Podana liczba to: "+firstNumber);
		System.out.println("Podaj znak /, +, -, *");
		String sign=scan.nextLine();
		System.out.println("Podano znak: "+sign);
		System.out.println("Podaj drugą liczbę");
		double secondNumber=scan.nextDouble();
		scan.nextLine();
		System.out.println("Podano druga liczbe: "+secondNumber);
		
	}

}
