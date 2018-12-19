package utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import data.Cone;
import data.Cube;
import data.Shape;
import data.Sphere;

public class Calculate {
	private Scanner sc;

	public Calculate() {
		sc = new Scanner(System.in);

	}

	public void close() {
		sc.close();
	}

	public Cone calculateCone() throws InputMismatchException {
		double r = 0;
		double h = 0;
		try {
			System.out.println("Podaj promien podstawy: ");
			r = sc.nextDouble();
			sc.nextLine();
			System.out.println("Podaj wysokosc stożka: ");
			h = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		return new Cone(r, h);

	}

	public Sphere calculateSphere() throws InputMismatchException {
		double r = 0;
		try {
			System.out.println("Podaj promien: ");

			r = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		return new Sphere(r);
	}

	public Cube calculateCube() throws InputMismatchException {
		double a = 0;
		try {
			System.out.println("Podaj długość boku: ");
			a = sc.nextDouble();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		return new Cube(a);

	}

	public Shape createShape() throws InputMismatchException, NoSuchElementException {
		try {
			int shapeType = sc.nextInt();
			sc.nextLine();
			switch (shapeType) {
			case Shape.CONE:
				return calculateCone();
			case Shape.CUBE:
				return calculateCube();
			case Shape.SPHERE:
				return calculateSphere();
			default:
				throw new NoSuchElementException();
			}
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}

	}
	

}
