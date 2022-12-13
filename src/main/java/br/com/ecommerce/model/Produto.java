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
@Table(name = "produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String codigo;
	
	private String imagem;
		
	@Column(nullable = false, precision = 10, scale = 2)
	@Type(type = "big_decimal")
	private BigDecimal precoCusto;
			
	@Column(nullable = false, precision = 10, scale = 2)
	@Type(type = "big_decimal")
	private BigDecimal precoVenda;
	
	@Column(length = 40)
	private String cor;
	
	@Column(nullable = false)
	private String descricao;

	@Temporal(TemporalType.DATE)	
	@Column(nullable = true)
	private Date dataFabricacao;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataValidade;
		
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataCadastro;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtualizacao;
	
	@OneToOne()
	private Desconto desconto;
	
	@OneToOne()
	private MargemLucro margemLucro;
	
	@OneToOne()
	private Categoria categoria;
	
	@OneToOne ()
	private Imposto imposto;
	
	@OneToOne()
	private UnidadeMedida unidadeMedida;
	
	@OneToOne
	private Marca marca;
}