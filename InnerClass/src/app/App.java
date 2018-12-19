package app;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] array = { 11, 10, 9, 1, 2, 3,20,21,6};
		Sort sort = new Sort() {

			@Override
			public int[] bubble(int[] tab) {
				int temp;
				int count=0;
				boolean sortFinished = false;
				while (sortFinished != true) {
					count++;
					System.out.println("*");
					sortFinished = true;
					for (int j = 1; j < tab.length; j++) {
						
						System.out.println(tab[j-1] + "i" + tab[j] + " " + (tab[j-1] > tab[j]));
						if (tab[j - 1] > tab[j]) {
							
							temp = tab[j];
							tab[j] = tab[j - 1];
							tab[j - 1] = temp;
							sortFinished = false;
							
						}

					}
				}
				System.out.println("Ilosc petli: "+count);
				return tab;
			}
		};

		System.out.println(Arrays.toString(sort.bubble(array)));

	}
}