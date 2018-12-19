package app;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Podaj ilosc liczb");
		int temp=scan.nextInt();
		scan.nextLine();
		System.out.println("podana ilosc liczb to: "+temp);
		int[] tempArray=new int[temp];
		for(int i=0;i<temp;i++) {
			System.out.println("Podaj "+(i+1)+" liczbe: ");
			tempArray[i]=scan.nextInt();
			scan.nextLine();
		}
		scan.close();
		System.out.println("Podane liczby to: "+Arrays.toString(tempArray));
		System.out.println("Suma podanych liczb to: "+IntStream.of(tempArray).sum());
	}

}
