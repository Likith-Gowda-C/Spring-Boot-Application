package com.jsp.springboot.studentdatabase.exception;

public class UpdateByStudentIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public UpdateByStudentIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
