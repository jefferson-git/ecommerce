package br.com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.HistoricoCustoProduto;

public interface HistoricoCustoProdutoRepository extends JpaRepository<HistoricoCustoProduto, Long>{

	List<HistoricoCustoProduto> findByNomeProduto(String nome);
	List<HistoricoCustoProduto> findByNomeProdutoContaining(String nome);
	List<HistoricoCustoProduto> findByCodigoProduto(String codigo);	 
}
