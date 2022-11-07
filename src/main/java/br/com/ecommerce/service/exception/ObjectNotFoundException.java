package br.com.ecommerce.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("serial")
public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}   
}
