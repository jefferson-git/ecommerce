package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class UnidadeMedidaDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@NotBlank(message = "O campo nome é requerido!")
	@Size(min = 2, max = 30, message = "nome deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou:" + "${validatedValue}")
	private String nome;
	
	@NotBlank(message = "O campo descrição é requerido!")
	@Size(min = 6, max = 100, message = "Descrição deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou:" + "${validatedValue}")
	private String descricao;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;

}
