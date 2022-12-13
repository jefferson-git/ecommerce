package br.com.ecommerce.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
public class HistoricoCustoProdutoDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	private BigDecimal precoCusto;
	
	private String nomeProduto;
	
	private String codigoProduto;
	
	private Date DataDoHistorico;
}