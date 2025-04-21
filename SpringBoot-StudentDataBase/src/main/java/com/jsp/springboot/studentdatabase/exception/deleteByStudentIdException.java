package com.jsp.springboot.studentdatabase.exception;

public class deleteByStudentIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public deleteByStudentIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
