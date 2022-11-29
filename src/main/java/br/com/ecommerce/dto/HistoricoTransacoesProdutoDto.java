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
public class HistoricoTransacoesProdutoDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@Digits(integer = 10, fraction = 2, message = "O campo preço deve ser observado sua formatação!.")
	private BigDecimal precoVenda;

	@NotBlank(message = "A data da venda é requerida!")
	private Date DataDaVenda;
	
	private Produto produto;
}
