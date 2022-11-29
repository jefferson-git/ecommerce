package br.com.ecommerce.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.model.Desconto;
import br.com.ecommerce.model.Imposto;
import br.com.ecommerce.model.Marca;
import br.com.ecommerce.model.MargemLucro;
import br.com.ecommerce.model.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class ProdutoDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@NotBlank(message = "O campo nome é requerido")
	@Size(min = 2, max = 100, message = "Descrição deve ter no máximo {max} caracteres e no minimo" + "{min} caracteres. Você digitou:" + "${validatedValue}")
	private String nome;
	
	@NotBlank(message = "O campo codigo é requerido")
	private String codigo;

	@Min( value = 0, message = "A quantidade deve ser zero ou  superior")
	private Integer quantidade;
	
	private String imagem;
		
	@DecimalMin("0.00") 
	@DecimalMax("9999999999.00")
	@Digits(integer = 10, fraction = 2)	
	private BigDecimal precoCusto;
	
	@DecimalMin("0.00") 
	@DecimalMax("9999999999.00")
	@Digits(integer = 10, fraction = 2)
	private BigDecimal precoVenda;
	
	private String cor;
	
	@NotBlank(message = "O campo descrição é requerido")
	private String descricao;

	private Date dataCadastro;
	
	private Date dataAtualizacao;
	
	private Desconto desconto;
	
	private MargemLucro margemLucro;
		
	private Categoria categoria;
	
	private Imposto imposto;
	
	private UnidadeMedida unidadeMedida;
	
	private Marca marca;
}
