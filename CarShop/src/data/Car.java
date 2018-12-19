package data;

public class Car {
	private int productionDate;
	private String name;
	private String model;
	private String color;

	public Car(int productionDate, String name, String model, String color) {
		this.setProductionDate(productionDate);
		this.setName(name);
		this.setModel(model);
		this.setColor(color);

	}

	public int getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(int productionDate) {
		this.productionDate = productionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}