package app;

import java.util.Scanner;

public class Pizzeria {

	public static void main(String[] args) {
		
		System.out.println("Wyswietl wszystkie pizze");		
		for(Pizza p:Pizza.values()) {
			System.out.println(p.name()+" "+p);
		}
		System.out.println("podaj pizze");
		Scanner scan=new Scanner(System.in);
		Pizza pizz1=Pizza.valueOf(scan.nextLine());
		System.out.println(pizz1.name()+pizz1);
		scan.close();
	}

}
