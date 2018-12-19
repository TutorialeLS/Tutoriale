package data;

public class Cube implements Shape {
	private double a;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}
	
	public Cube(double a) {
		setA(a);
	}

	@Override
	public double area() {
		return Math.pow(a, 2)*6;
	}

	@Override
	public double volume() {
		return Math.pow(a,3);
	}
	
}
