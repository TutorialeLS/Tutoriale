package app;

public class Fruit {
	private String owoc;
	 public void printInfo() {
		System.out.print("Owoc");
	}
	 Fruit(){
		 this.setOwoc(owoc);
		 System.out.println(owoc);
	 }
	public String getOwoc() {
		return owoc;
	}
	public void setOwoc(String owoc) {
		this.owoc = owoc;
	}
}
