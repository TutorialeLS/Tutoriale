package app;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Shape;
import utils.Calculate;

public class App {
	public static void main(String args[]) {
		App main =new App();
		
		Calculate calc=new Calculate();
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
		calc.close();
	}
	
	private void printOptions() {
		   System.out.println("Wybierz figurę, dla której chcesz obliczyć pole i obwód:");
	    
	       
	        System.out.println(Shape.CONE + " - trójkąt");
	        System.out.println(Shape.CUBE + " - prostokąt");
	        System.out.println(Shape.SPHERE + " - koło");
		
	}
}
