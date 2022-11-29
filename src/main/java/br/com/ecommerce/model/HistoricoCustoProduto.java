package br.com.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "historico_de_custo_do_produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistoricoCustoProduto{
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(nullable = false)
	private BigDecimal precoCusto;
	
	@Column(nullable = false)
	private String nomeProduto;
	
	@Column(nullable = false)
	private String codigoProduto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date Data;
	
	@OneToOne()
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
}