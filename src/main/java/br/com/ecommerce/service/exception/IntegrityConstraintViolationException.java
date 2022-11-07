package br.com.ecommerce.service.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter @Getter
public class IntegrityConstraintViolationException extends RuntimeException{

	public IntegrityConstraintViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegrityConstraintViolationException(String message) {
		super(message);
	}
}
