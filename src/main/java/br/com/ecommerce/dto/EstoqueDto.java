package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class EstoqueDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@NotBlank(message =  "O campo quantidade é requerido!")
	@Size(min = 0, message = "A quantidade não pode ser negativa!")
	private Long quantidadeEntrada;
	
	@Size(min = 0, message = "A quantidade total não pode ser negativa!")
	private Long quantidadeTotal;
	
	@NotBlank(message =  "O campo data de entrada é requerido!")
	private Date DataDeEtrada;
	
	@NotBlank(message =  "O campo data de fabricação é requerido!")
	private Date DataDeFabricacao;
	
	@NotBlank(message =  "O campo data de vencimento é requerido!")
	private Date DataDaVencimento;
	
	private Produto produto;
}
