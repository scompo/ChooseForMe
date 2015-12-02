package com.github.scompo.chooseforme.domain;

public class StuffToChoose {

	private String name;

	public StuffToChoose() {
		
		this(null);
	}

	public StuffToChoose(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StuffToChoose [name=" + name + "]";
	}
}
