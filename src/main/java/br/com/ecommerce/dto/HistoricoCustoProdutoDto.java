package br.com.ecommerce.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ecommerce.model.Produto;
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
	
	@Digits(integer = 10, fraction = 2, message = "O campo preço deve ser observado sua formatação!.")
	private BigDecimal preco;

	@NotBlank(message = "O nome do produto é requerido para histórico de custo do produto!")
	private String nomeProduto;
	
	@NotBlank(message = "O codigo do produto é requerido para histórico de custo do produto!")
	private String codigoProduto;
	
	@NotBlank(message = "A data da é requerida!")
	private Date Data;
	
	private Produto produto;
}
