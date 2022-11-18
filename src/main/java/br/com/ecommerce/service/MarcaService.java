package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.MarcaDto;
import br.com.ecommerce.model.Marca;

public interface MarcaService {

	Marca findById(Long id);
	List<Marca> findAll();
	Marca create(MarcaDto dto);
	Marca update(Long id, MarcaDto dto);
	void delete(Long id);
}
