package br.com.ecommerce.service.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter @Getter
public class HttpMessageNotReadableException extends RuntimeException{

	public HttpMessageNotReadableException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpMessageNotReadableException(String message) {
		super(message);
	}
}
