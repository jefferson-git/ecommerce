package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByNome(String nome);
	List<Produto> findByNomeContaining(String nome);
	List<Produto> findByCodigo(String codigo);	

}
