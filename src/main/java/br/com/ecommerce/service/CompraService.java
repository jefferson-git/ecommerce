package br.com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.model.Compra;
import br.com.ecommerce.model.Produto;

public interface CompraService {

	Compra findById(Integer id);
	Page<Compra> findAll(Pageable pageable);
	Compra create(CompraDto dto);
	Compra update(Integer id, CompraDto dto);
	void delete(Integer id);
	List<Produto> findByNomeContaining(String nome);
}
