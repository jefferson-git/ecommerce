package br.com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ecommerce.dto.ProdutoDto;
import br.com.ecommerce.model.Produto;

public interface ProdutoService {

	Produto findById(Long id);
	Page<Produto> findAll(Pageable pageable);
	Produto create(ProdutoDto dto);
	Produto update(Long id, ProdutoDto dto);
	void delete(Long id);
	List<Produto> findByNomeProduto(String nome);
	List<Produto> findByNomeProdutoContaining(String nome);
	List<Produto> findByCodigoProduto(String codigo);
}
