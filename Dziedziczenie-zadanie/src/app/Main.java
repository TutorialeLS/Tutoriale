package app;

public class Main {

	public static void main(String[] args) {
		Part prt1=new Part(123);
		Tire prt2=new Tire(124,5,6);
		System.out.println(prt1.number);
		System.out.println(prt2.number+" "+prt2.getSize()+" "+prt2.getWidth());
		
	}

}
