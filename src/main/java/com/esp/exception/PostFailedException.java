package com.esp.exception;

public class PostFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 111L;

	public PostFailedException(Integer id) {
		super("Id should not be a negative integer! " + id);
		// TODO Auto-generated constructor stub
	}
	
	

}
