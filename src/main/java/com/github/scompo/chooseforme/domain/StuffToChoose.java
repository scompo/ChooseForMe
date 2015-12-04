package com.github.scompo.chooseforme.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StuffToChoose implements Serializable {

	private static final long serialVersionUID = -1606954157038119885L;

	public static final StuffToChoose NOT_PRESENT = new StuffToChoose("empty list");
	
	/**
	 * Minimum name length.
	 */
	public static final int MIN_NAME_LENGTH = 1;

	/**
	 * Maximum name length.
	 */
	public static final int MAX_NAME_LENGTH = 250;

	@NotNull
	@Size(min = MIN_NAME_LENGTH, max = MAX_NAME_LENGTH)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StuffToChoose other = (StuffToChoose) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StuffToChoose [name=" + name + "]";
	}
}
