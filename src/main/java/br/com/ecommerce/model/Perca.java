package br.com.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Valid
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "perca")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String nomeProduto;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(nullable = false)
	private String codigoProduto;
	
	@Column(nullable = false)
	private String MotivoDaPerca;
	
	@Temporal(TemporalType.DATE)
	private Date dataDaPerca;
	
	
}