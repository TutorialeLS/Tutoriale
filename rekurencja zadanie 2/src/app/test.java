package app;

import java.io.File;

public class test {
	   public static void main(String[] args) {
	        test dl = new test();
	        System.out.println(dl.rekurencja(50));
	    }
	   public int rekurencja(int a) {
		   
		   
		return a>1?a*rekurencja(a-1):1;
		   
	   }
}
