package com.techelevator.reservations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AuthorizationException extends Exception {
	private static final long serialVersionUID = 1L;
}
