package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.UnidadeMedidaDto;
import br.com.ecommerce.model.UnidadeMedida;

public interface UnidadeMedidaService {

	UnidadeMedida findById(Integer id);
	List<UnidadeMedida> findAll();
	UnidadeMedida create(UnidadeMedidaDto dto);
	UnidadeMedida update(Integer id, UnidadeMedidaDto dto);
	void delete(Integer id);
}
