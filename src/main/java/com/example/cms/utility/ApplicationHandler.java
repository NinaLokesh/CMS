package com.example.cms.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.cms.exception.UserAlreadyExistsByEmailException;
import com.example.cms.exception.UserNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	private ErrorStructure<String> structure;

	public ApplicationHandler(ErrorStructure<String> structure) {
		super();
		this.structure = structure;
	}


	private ResponseEntity<ErrorStructure<String>> errorResponse(HttpStatus status, String message, String rootCause) {

		return new ResponseEntity<ErrorStructure<String>>(structure.setStatusCode(status.value())
				.setErrorMessage(message)
				.setRootCause(rootCause),status);
	}


	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> userAlreadyExistsByEmailException(UserAlreadyExistsByEmailException ex) {

		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "User already exists with given email");
	}


	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> userNotFoundByIdException(UserNotFoundByIdException ex) {

		return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), "User with given ID does not exist");
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
