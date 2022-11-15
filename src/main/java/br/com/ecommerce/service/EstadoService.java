package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.EstadoDto;
import br.com.ecommerce.model.Estado;

public interface EstadoService {
	
	Estado findById(Integer id);
	List<Estado> findAll();
	Estado create(EstadoDto dto);
	Estado update(Integer id, EstadoDto dto);
	void delete(Integer id);
}
