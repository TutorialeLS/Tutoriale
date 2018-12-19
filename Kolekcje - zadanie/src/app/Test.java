package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		List<Integer> numbers=generate();
		List<Integer> temp=new ArrayList<>();
		List<Integer> randomizedNumbers=new ArrayList<>();
		System.out.println(numbers);
		
		
		randomizedNumbers=randomize(numbers);	
		System.out.println(randomizedNumbers);
		
		int counter=1;
		while(checkResult(numbers)<6) {			
			checkResult(numbers);
			counter++;
			temp=numbers;
		randomizedNumbers=randomize(numbers);
		}
		System.out.println(temp);
		System.out.println(randomizedNumbers);
		System.out.println("wylosowano za "+counter+" razem");
	
		
		
		
		
	}

	public static List<Integer> generate() {
		List<Integer> numbers = new ArrayList<>();
		for (Integer i = 1; i <= 49; i++) {
			numbers.add(i);
		}

		return numbers;
	}
	
	public static List<Integer> randomize(List<Integer> numbers){
		Collections.shuffle(numbers);		
		return numbers;
	}
	public static int checkResult(List<Integer> numbers) {
		int counter=1;
		List<Integer> checkNumbers=new ArrayList<>();
		//Scanner sc= new Scanner(System.in);
		//System.out.println("Podaj pierwsza liczbe");
		checkNumbers.add(1);
		//System.out.println("Podaj druga liczbe");
		checkNumbers.add(2);
		//System.out.println("Podaj trzecia liczbe");
		checkNumbers.add(3);
	//	System.out.println("Podaj czwarta liczbe");
		checkNumbers.add(4);
		//System.out.println("Podaj piata liczbe");
		checkNumbers.add(5);
	//	System.out.println("Podaj szosta liczbe");
		checkNumbers.add(6);
		
        for(int i=1; i<=6; i++) {
            if(checkNumbers.contains(numbers.get(i))) {
                counter++;
            }
        }
        System.out.println("Trafiono "+counter+" liczb!");
        return counter;
	}
}
