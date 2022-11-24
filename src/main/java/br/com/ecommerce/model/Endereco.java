package br.com.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 40, nullable = false)
	private String logradouro;
	
	private String complemento;
	
	private String numero;
	
	@Column(nullable = false)
	private String bairro;
	
	private String principal;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
}
