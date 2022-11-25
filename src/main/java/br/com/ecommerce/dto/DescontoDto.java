package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class DescontoDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@Digits(integer = 3, fraction = 1, message = "Dois digítos antes do ponto e apenas uma casas após o ponto.")
	private Float porcentagem;
	
	@NotBlank(message = "O campo descrição é requerido!")
	private String descricao;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
}
