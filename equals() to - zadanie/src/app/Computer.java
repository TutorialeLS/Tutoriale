package app;

public class Computer {
	private String producer;
	private int model;

	public Computer(int model, String producer) {
		setProducer(producer);
		setModel(model);
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model2) {
		this.model = model2;
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Computer))
			return false;

		Computer s = (Computer) obj;

		if(this.producer!=null)
			if(producer.equals(s.getProducer())&&s.getModel()==this.model)
				return true;
		return false;
	}
	  public String toString() {
	        return model + " " + producer;
	    }

}
