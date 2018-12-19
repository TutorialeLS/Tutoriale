package app;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		double temp=1.0;
		double[][] tab=new double[3][3];
		
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab[i].length;j++) {
				tab[i][j]=temp;
				temp=temp+0.5;
			}
		}
		
		System.out.println(Arrays.toString(tab[2]));
	}

}
