package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ecommerce.model.Cidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class EnderecoDto implements Serializable{

	@JsonIgnore
	private Long id;
	
	@NotBlank(message = "O cep é requerido.")
	private String cep;
	
	@NotBlank(message = "O logradouro é requerido.")
	private String logradouro;
	
	@Size(max = 255, message = "Complemento deve ter no máximo {max} caracteres. Você digitou:" + "${validatedValue}")
	private String complemento;
	
	@Size(max = 10, message = "O número tem a limitação de dez caracteres. Você digitou:" + "${validatedValue}\"") 
	private String numero;
	
	@NotBlank(message = "O bairro é requerido.")
	private String bairro;
	
	private String principal;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
}
