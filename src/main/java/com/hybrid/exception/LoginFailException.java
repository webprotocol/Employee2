package com.hybrid.exception;


public class LoginFailException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginFailException() {
		super();
	}
	
	public LoginFailException(String message) {
		super(message);
	}

}
