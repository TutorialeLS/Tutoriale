package data;

public class Sphere implements Shape {
	private double r;

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public Sphere(double r) {
		setR(r);
	}

	@Override
	public double area() {
		return 4 * Math.PI * r * r;
	}

	@Override
	public double volume() {
		return (4 * Math.PI * r * r * r) / 3;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Kula, ");
		sb.append("promień: " + r + ", ");
		sb.append("pole: " + area() + ", ");
		sb.append("objetosc: " + volume());
		return sb.toString();
	}

}
