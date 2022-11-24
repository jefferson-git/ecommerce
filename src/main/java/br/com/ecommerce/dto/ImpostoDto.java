package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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
public class ImpostoDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 3, fraction = 1, message = "Dois digítos antes do ponto e apenas uma casas após o ponto.")
	private Float porcentagem;
	
	@Size(min = 4, max = 100, message = "Descrição deve ter no máximo {max} caracteres e no minimo" + "{min} caracteres. Você digitou:" + "${validatedValue}")
	private String descricao;
	
	private Date DataCriacao;
	
	private Date DataAtualizacao; 
}
