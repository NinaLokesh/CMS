package com.example.cms.exception;

public class UserAlreadyExistsByEmailException extends RuntimeException {
	
	private String message;

	public UserAlreadyExistsByEmailException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
