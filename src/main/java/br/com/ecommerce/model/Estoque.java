package br.com.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estoque")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nomeProduto;
	
	@Column(nullable = false, unique = true)
	private String codigoProduto;
	
	@Column(nullable = false)
	private Integer quantidadePorCompra = 0;
	
	@Column(nullable = false)
	private Integer quantidadeTotalEmEstoque =  0;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDeEntrada;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDeFabricacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDeVencimento;

}