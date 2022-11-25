package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.DescontoDto;
import br.com.ecommerce.model.Desconto;

public interface DescontoService {

	Desconto findById(Integer id);
	List<Desconto> findAll();
	Desconto create(DescontoDto dto);
	Desconto update(Integer id , DescontoDto dto);
	void delete(Integer id);
}
