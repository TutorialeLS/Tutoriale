package app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	public static void main(String args[]) {
		App main =new App();
		
		Calc calc=new Calc();
		Shape shape=null;
		
		boolean readComplete=false;
		while(!readComplete) {
			try {
				main.printOptions();
				shape=calc.createShape();
				readComplete = true;
			}catch(InputMismatchException e) {
				System.out.println("Dane w zlym formacie");
			}catch(NoSuchElementException e) {
				System.out.println("Nie ma takiego kształtu");
			}
			
		}
		System.out.println(shape);
		calc.closeScanner();
	}

	private void printOptions() {
		   System.out.println("Wybierz figurę, dla której chcesz obliczyć pole i obwód:");
	        System.out.println(Shape.RECT + " - prostokąt");
	        System.out.println(Shape.CIRCLE + " - koło");
	        System.out.println(Shape.TRIANGLE + " - trójkąt");
		
	}
}
