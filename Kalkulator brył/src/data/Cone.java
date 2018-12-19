package data;

public class Cone implements Shape {
	
	private double r;
	private double h;
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	
	public Cone(double r, double h) {
		setR(r);
		setH(h);
	}
	
	@Override
	public double area() {
		return (Math.PI*r*r)+Math.PI*r*Math.sqrt(Math.pow(r, 2)+Math.pow(h, 2));
	}
	@Override
	public double volume() {
		return (Math.PI*r*r*h)/3;
	}
	
	

}
