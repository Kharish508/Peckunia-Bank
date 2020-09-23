package com.capg.tms.Exception;

public class InSufficientException  extends RuntimeException{

	public InSufficientException(String message) {
		super(message);
	}
	
	public InSufficientException() {
		super();
	}
}
