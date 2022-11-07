package br.com.ecommerce.controller.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor @Getter
@AllArgsConstructor @Setter
public class FieldMessenger implements Serializable {

	private String fieldName;
	private String menssage;
	
}
