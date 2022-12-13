package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class EstoqueDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@NotBlank(message =  "O campo código produto em estoque é requerido!")
	private String nomeProduto;
	
	@NotBlank(message =  "O campo código produto em estoque é requerido!")
	private String codigoProduto;
	
	@Min(value = 1, message = "A quantidade da compra mínima deve ser, {value}. Você digitou: " + "${validatedValue}.")
	private Integer quantidadePorCompra = 0;
	
	private Integer quantidadeTotalEmEstoque = 0;
	
	private Date DataDeEntrada;
	
	@NotNull(message =  "O campo data de fabricação é requerido!")
	private Date DataDeFabricacao;
	
	@NotNull(message =  "O campo data de vencimento é requerido!")
	private Date DataDeVencimento;
}
