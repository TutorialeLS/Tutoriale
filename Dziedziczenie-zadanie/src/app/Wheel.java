package app;

public class Wheel extends Part {
	private int size;
	private int width;
	public Wheel(int number, int size, int width) {
		super(number);
		this.setSize(size);
		this.setWidth(width);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

}