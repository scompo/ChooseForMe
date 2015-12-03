package com.github.scompo.chooseforme.exceptions;

public class EmptyListException extends Exception {

	private static final long serialVersionUID = -6492333075443185185L;

	public EmptyListException() {

		super();
	}

	public EmptyListException(String message) {

		super(message);
	}

	public EmptyListException(Throwable cause) {

		super(cause);
	}

	public EmptyListException(String message, Throwable cause) {

		super(message, cause);
	}

	public EmptyListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

}
