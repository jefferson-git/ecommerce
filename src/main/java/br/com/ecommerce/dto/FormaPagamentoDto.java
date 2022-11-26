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
public class FormaPagamentoDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@NotBlank(message = "O campo nome é requerido")
	private String nome;
	
	@NotBlank(message = "O descrição é requerido")
	private String descircao;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
}
