package com.github.scompo.chooseforme.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Stuffs extends ArrayList<StuffToChoose>{

	public Stuffs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stuffs(Collection<? extends StuffToChoose> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public Stuffs(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 3401471504840787452L;

	@Override
	public String toString() {
		return "Stuffs [toString()=" + super.toString() + "]";
	}


}
