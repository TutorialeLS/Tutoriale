package app;

public class Apple extends Fruit {
	private String odmiana;
	
	Apple(String odmiana) {
		setOdmiana(odmiana);
		// TODO Auto-generated constructor stub
	}

	public String getOdmiana() {
		return odmiana;
	}

	public void setOdmiana(String odmiana) {
		this.odmiana = odmiana;
	}
	public void printInfo() {
		super.printInfo();
		System.out.println(":Jabłko:" + getOdmiana());
	}

}
