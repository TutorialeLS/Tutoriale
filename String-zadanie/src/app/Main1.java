package app;

import java.util.Scanner;

public class Main1 {
	public static void main(String args[]) {
		int number=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("Podaj liczbe wyrazow");
		number=scan.nextInt();
		scan.nextLine();
		System.out.println("Podano "+number+" liczbe wyrazow");
		StringBuffer result=new StringBuffer();
		for(int i=0;i<number;i++) {
		System.out.println("Podaj "+(i+1)+" wyraz");
		String str=scan.nextLine();
		result.append(str.charAt(str.length()-1));
		}
		System.out.println("powstaly wyraz to: "+result.toString());
		scan.close();
		
		}
}
