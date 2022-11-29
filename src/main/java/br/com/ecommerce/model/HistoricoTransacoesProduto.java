package br.com.ecommerce.model;

import java.math.BigDecimal;
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

import org.hibernate.annotations.Type;

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
@Table(name = "historico_de_transacoes_do_produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistoricoTransacoesProduto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, precision = 10, scale = 2)
	@Type(type = "big_decimal")
	private BigDecimal precoVenda;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date DataDaVenda;
	
	@ManyToOne
	private Produto produto;
}
