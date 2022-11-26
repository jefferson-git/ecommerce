package br.com.ecommerce.service;

import java.util.List;

import br.com.ecommerce.dto.FormaPagamentoDto;
import br.com.ecommerce.model.FormaPagamento;

public interface FormaPagamentoService {

	FormaPagamento findById(Integer id);
	List<FormaPagamento> findAll();
	FormaPagamento create(FormaPagamentoDto dto);
	FormaPagamento update(Integer id, FormaPagamentoDto dto);
	void delete(Integer id);
}
