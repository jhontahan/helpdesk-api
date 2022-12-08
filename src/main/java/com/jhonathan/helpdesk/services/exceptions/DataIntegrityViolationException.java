package com.jhonathan.helpdesk.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException{

	private static final long serialVersionUID = -8987262726312875408L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}

	
	
}
