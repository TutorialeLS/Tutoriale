package app;

public class Main {

	public static void main(String[] args) {
		double intSalary=100;
		double percentage=1.02;
		int halfYears=12*18;
		for(int i=0;i<halfYears;i++) {
			intSalary=intSalary+1000;
			if(i%12==0) {
			intSalary=intSalary*percentage;
			System.out.println("Wyplata w roku " +i/12+" to: "+intSalary);
			}
		}

	}

}
