package br.com.ecommerce.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import br.com.ecommerce.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class CidadeDto implements Serializable{

	private Integer id;
	
	@NotBlank(message = "O nome é requerido!")
	private String nome;
	
	private Date dataCriacao = new Date();
	
	private Estado estado;
}
