package app;

public class ExhaustPart extends Part {
	private boolean compatible;

	public ExhaustPart(int number, boolean compatible) {
		super(number);
		this.setCompatible(compatible);
}

	public boolean isCompatible() {
		return compatible;
	}

	public void setCompatible(boolean size) {
		this.compatible = size;
	}
}