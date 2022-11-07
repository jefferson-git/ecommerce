package br.com.ecommerce.controller.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("serial")
public class StandardError implements Serializable{
	
	private final Long timestamp;
	private final Integer status;
	private final String mensage;
	private final String documentation;
	
	public StandardError(Long timestamp, Integer status, String mensage, String urlDocumentation) {
		this.timestamp = timestamp;
		this.status = status;
		this.mensage = mensage;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        documentation = url + urlDocumentation;
	}	
}
