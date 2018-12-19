package app;

public class Main {

	public static void main(String[] args) {
		Numbers num=new Numbers();
		num.add(3,5);
		int number3=num.get(3);
		System.out.println(number3);
		num.add(20, 20);
		int number20=num.get(20);
		System.out.println(number20);
	}

}
