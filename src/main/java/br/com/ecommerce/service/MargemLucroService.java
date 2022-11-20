package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.MargemLucroDto;
import br.com.ecommerce.model.MargemLucro;

public interface MargemLucroService {

	MargemLucro findById(Integer id);
	List<MargemLucro> findAll();
	MargemLucro create(MargemLucroDto dto);
	MargemLucro update(Integer id, MargemLucroDto dto);
	void delete(Integer id);
}
