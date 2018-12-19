package pl.javastart.model;

import pl.javastart.constraint.LongEnough;

public class StringBean {
	@LongEnough(length = 5)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBean(String name) {
		super();
		this.name = name;
	}

}
