package br.com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.model.HistoricoCustoProduto;

public interface HistoricoCustoProdutoService {

	HistoricoCustoProduto findById(Long id);
	Page <HistoricoCustoProduto> findAll(Pageable pageable);
	HistoricoCustoProduto create(CompraDto dto, HistoricoCustoProduto historico);
	void delete(Long id);
	List <HistoricoCustoProduto> findByNomeProdutoHistorico(String nome);
	List<HistoricoCustoProduto> findByNomeProdutoContainingHistorico(String nome);
	List<HistoricoCustoProduto> findByCodigoProdutoHistorico(String codigo);
}
