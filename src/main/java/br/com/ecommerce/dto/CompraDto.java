package br.com.ecommerce.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
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
public class CompraDto implements Serializable{

	@JsonIgnore
	private Integer id;
	
	@Min(value = 1, message = "A quantidade da compra mínima deve ser, {value}. Você digitou: " + "${validatedValue}.")
	@NotNull(message = "O campo quantidade é requerido!")
	private Integer quantidade;
	
	@NotBlank(message = "O nome do produto é requerido!")
	private String nomeProduto;
	
	@DecimalMin(value = "0.1", inclusive = false, message = "O campo valor unitário deve ser maior que zero!")
	@Digits(integer = 10, fraction = 2, message = "Dois digítos decimais após o ponto.")
	private BigDecimal valorUnitario;
	
	@NotBlank(message = "O código do produto é requerido!")
	private String codigoProduto;
	
    @NotNull(message = "A data da compra é requerido!")
	private Date dataDaCompra;
	
    @NotNull(message = "A data de fabricação é requerido!")
	private Date dataDeFabricacao;
	
    @NotNull(message = "A data de validade do produto é requerido!")
	private Date dataDeValidade;	
}
