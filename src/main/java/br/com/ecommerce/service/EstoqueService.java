package br.com.ecommerce.service;

import java.util.List;

import javax.validation.Valid;

import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.dto.EstoqueDto;
import br.com.ecommerce.model.Estoque;
import br.com.ecommerce.model.Perca;

public interface EstoqueService {
	
	Estoque findById(Long id);
	List<Estoque> findAll();
	Estoque create(CompraDto compraDto, @Valid EstoqueDto estoqueDto);
	void update(Perca perca, Estoque estoque);
	void delete(Long id);
	List<Estoque> findByCodigoProdutoEstoque(String codigo);
}
