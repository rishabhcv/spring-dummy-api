package com.esp.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message) {
		super(message);
	}

}
