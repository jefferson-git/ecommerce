package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class MarcaDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@NotBlank(message = "O campo nome é requerido!")
	private String nome;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
}
