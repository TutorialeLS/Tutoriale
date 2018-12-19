package com.model.user;

import javax.validation.constraints.Min;

import com.library.validation.Divided;

public class Number {

	@Divided(by=3)
	@Min(value=3)
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	public Number(Integer number) {
		this.number=number;
	}
	
}
