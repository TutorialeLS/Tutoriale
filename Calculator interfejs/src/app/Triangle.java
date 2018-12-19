package app;

public class Triangle implements Shape {
	private double a;
	private double h;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	public Triangle(double a, double h) {
		setA(a);
		setH(h);
	}
	@Override
	public double area() {
		return a*h*0.5;
	}

	@Override
	public double length() {
		return a+2*(Math.sqrt(Math.pow(a,2)+Math.pow(h, 2)));
	}

}
