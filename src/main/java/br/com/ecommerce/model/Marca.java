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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marca")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@Temporal(TemporalType.DATE)
	@Column(unique = true)
	private Date dataAtualizacao;
}
