package app;

public class Rect implements Shape{
	private double a;
	private double b;
	
	public Rect(double a, double b) {
		setA(a);
		setB(b);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public double area() {
		return a*b;
	}

	@Override
	public double length() {
		return (2*a)+(2*b);
	}

}
