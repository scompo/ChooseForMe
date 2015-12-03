package com.github.scompo.chooseforme.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Stuffs extends ArrayList<StuffToChoose>{
	
	private static final long serialVersionUID = 3401471504840787452L;

	public Stuffs() {
		super();
	}

	public Stuffs(Collection<? extends StuffToChoose> c) {
		super(c);
	}

	public Stuffs(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public String toString() {
		return "Stuffs [toString()=" + super.toString() + "]";
	}


}
