package app;

public class Circle implements Shape {
	private double r;

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public Circle(double r) {
		setR(r);
	}
	
	@Override
	public double area() {
		return Math.PI * r * r;
	}

	@Override
	public double length() {
		return 2 * Math.PI * r;
	}

}
