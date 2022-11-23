package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.CategoriaDto;
import br.com.ecommerce.model.Categoria;

public interface CategoriaService {
	
	Categoria findById(Long id);
	List<Categoria> findAll();
	Categoria create(CategoriaDto dto);
	Categoria update(Long id, CategoriaDto dto);
	void delete(Long id);
}
