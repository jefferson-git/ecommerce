package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class FornecedorDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@NotBlank(message = "O campo nome é requerido!")
	private String nome;
	
	@NotBlank(message = "O campo cnpj é requerido!")
	private String cnpj;
	
	private Date dataCadastro;
}
