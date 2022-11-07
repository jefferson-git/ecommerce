package br.com.ecommerce.service.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter @Getter
public class BindException extends RuntimeException{

	public BindException(String message, Throwable cause) {
		super(message, cause);
	}

	public BindException(String message) {
		super(message);
	}
}
