package com.jsp.springboot.studentdatabase.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.studentdatabase.exception.NoStudentFoundException;
import com.jsp.springboot.studentdatabase.exception.StudentNotFoundByIdException;
import com.jsp.springboot.studentdatabase.exception.UpdateByStudentIdException;
import com.jsp.springboot.studentdatabase.exception.deleteByStudentIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>
	handelNoStudentFoundException(NoStudentFoundException nse){
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(nse.getMessage());
		es.setError("No Students Found!!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>
	handelStudentNotFoundByIdException(StudentNotFoundByIdException snfe){
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(snfe.getMessage());
		es.setError("Invalid Student ID!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>
	handelUpdateStudentByIdException(UpdateByStudentIdException uex){
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(uex.getMessage());
		es.setError("Student with Given Student ID is not present For Updating the Student Data!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>
	handelDeleteByStudentIdException(deleteByStudentIdException dex){
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(dex.getMessage());
		es.setError("Student with Given Student ID is not present For Deleting the Student Data!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
}
