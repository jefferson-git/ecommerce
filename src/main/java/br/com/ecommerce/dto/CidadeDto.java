package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ecommerce.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class CidadeDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@NotBlank(message = "O nome é requerido!")
	private String nome;
	
	private Date dataCriacao;
	
	private Estado estado;
}
