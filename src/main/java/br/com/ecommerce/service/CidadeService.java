package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.CidadeDto;
import br.com.ecommerce.model.Cidade;

public interface CidadeService {

	Cidade findById(Integer id);
	List<Cidade> findAll();
	Cidade create(CidadeDto dto);
	Cidade update(Integer id, CidadeDto dto);
	void delete(Integer id);	
}
