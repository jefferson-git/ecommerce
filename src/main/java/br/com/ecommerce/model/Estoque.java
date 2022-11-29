package br.com.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estoque")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estoque {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Long quantidadeEntrada = (long) 0;
	
	@Column(nullable = false)
	private Long quantidadeTotal = (long) 0;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDeEtrada;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDeFabricacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date DataDaVencimento;
	
	@ManyToOne
	private Produto produto;
}
