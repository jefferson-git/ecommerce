package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class EstadoDto implements Serializable{
	
	private Integer id;	
	
	@NotBlank(message = "O campo nome é requerido!")
	private String nome;
	
	@NotBlank(message = "O campo sigla é requerido!")
	private String sigla;
	
	//@NotBlank(message = "O campo Data de criação é requerido!")
	private Date dataCriacao;
	
	private Date dataAtualizacao;
}
