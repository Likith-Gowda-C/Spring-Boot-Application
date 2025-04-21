package com.jsp.springboot.studentdatabase.utility;

public class ErrorStructure <T>{
	
	private int statusCode;
	private String errorMessage;
	private T error;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getError() {
		return error;
	}
	public void setError(T error) {
		this.error = error;
	}
}
