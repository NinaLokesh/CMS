package com.example.cms.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure {
	
	private int statusCode;
	private String errorMessage;
	private Object rootCause;
	
	public int getStatusCode() {
		return statusCode;
	}
	public ErrorStructure setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
}
