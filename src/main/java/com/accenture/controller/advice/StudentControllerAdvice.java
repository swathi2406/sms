package com.accenture.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.accenture.exception.StudentIdMismatch;

@RestControllerAdvice
public class StudentControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidations(MethodArgumentNotValidException e)
	{
		ErrorResponse er = new ErrorResponse();
		er.setMessage(e.getMessage());
		er.setCode("ERR-400");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	@ExceptionHandler(StudentIdMismatch.class)
	public ResponseEntity<ErrorResponse> handleIDMismatch(StudentIdMismatch e)
	{
		ErrorResponse er = new ErrorResponse();
		er.setMessage("Student ID specified is not matching the ID in request body");
		er.setCode("ERR-400");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}

}
