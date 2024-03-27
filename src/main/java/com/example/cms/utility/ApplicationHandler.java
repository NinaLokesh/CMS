package com.example.cms.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {
	
	private ErrorStructure structure;

	public ApplicationHandler(ErrorStructure structure) {
		super();
		this.structure = structure;
	}
	
	
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		
//		Map<String, String> messages = new HashMap<>();
//		
//		ex.getAllErrors().forEach(error-> {
//			FieldError fieldError = (FieldError) error;
//			messages.put(fieldError.getField(), error.getDefaultMessage());
//		});
//		
//		return ResponseEntity.badRequest().body(
//				structure.setStatusCode(HttpStatus.BAD_REQUEST.value())
//				.setErrorMessage("Invalid inputs")
//				.setRootCause(messages));
//	}

}
