package br.com.ecommerce.service.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter @Getter
public class HttpRequestMethodNotSupportedException extends RuntimeException{

	public HttpRequestMethodNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpRequestMethodNotSupportedException(String message) {
		super(message);
	}
}
