package app;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Integer[] tab={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}; 

		System.out.println(Arrays.toString(tab));
		
		Arrays.sort(tab, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}
		});
		System.out.println(Arrays.toString(tab));
		Arrays.sort(tab, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1.compareTo(arg0);
			}
		});
		System.out.println(Arrays.toString(tab));
	}

}
