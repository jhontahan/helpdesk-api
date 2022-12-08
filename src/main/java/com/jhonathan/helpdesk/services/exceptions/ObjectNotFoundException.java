package com.jhonathan.helpdesk.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8987262726312875408L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

	
	
}
