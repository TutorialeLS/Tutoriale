package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		Integer[] valueInt=new Integer[5];
		int resultInt=0;
		int a=0; int b=0; int c=0;
        BigInteger aBig = null, bBig = null;
		String filename="plik.txt";
		try( FileReader fr = new FileReader(filename);
	     BufferedReader br = new BufferedReader(fr);)
		{
			    a=Integer.parseInt(br.readLine());
			    b=Integer.parseInt(br.readLine());
			    c=Integer.parseInt(br.readLine());
				aBig = new BigInteger(br.readLine());
	            bBig = new BigInteger(br.readLine());
		}catch(IOException e) {
			System.out.println("nie odnaleziono pliku");
		}
		System.out.println("wynik a +b +c: "+(a+b+c));
		System.out.println(aBig.add(bBig));
	

	}

}
