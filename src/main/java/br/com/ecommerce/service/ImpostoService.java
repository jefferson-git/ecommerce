package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.ImpostoDto;
import br.com.ecommerce.model.Imposto;

public interface ImpostoService {
	
	Imposto findById(Integer id);
	List<Imposto> findAll();
	Imposto create(ImpostoDto dto);
	Imposto update(Integer id, ImpostoDto dto);
	void delete(Integer id);
}
