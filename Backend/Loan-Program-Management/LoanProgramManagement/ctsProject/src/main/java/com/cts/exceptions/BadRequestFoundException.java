package com.cts.exceptions;

public class BadRequestFoundException extends RuntimeException {
	public BadRequestFoundException(String message) {
		super(message);
	}
}
