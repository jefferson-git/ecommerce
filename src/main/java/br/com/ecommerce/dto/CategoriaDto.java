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
public class CategoriaDto implements Serializable{

	@JsonIgnore
    private Long id;	
	
	@NotBlank(message = "O campo nome é requerido!")
	private String nome;
	
	@NotBlank(message = "O campo descrição é requerido!")
	private String descricao;

	private Date dataCriacao = new Date();
	
	private Date dataAtualizacao;
}
