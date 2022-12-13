package br.com.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ecommerce.dto.PercaDto;
import br.com.ecommerce.model.Perca;
import br.com.ecommerce.model.Produto;

public interface PercaService {

	Perca findById(Integer id);
	Page<Perca> findAll(Pageable pageable);
	Perca create(PercaDto dto);
	Perca update(Integer id, PercaDto dto);
	void delete(Integer id);
	List<Produto> findByCodigoProduto(String codigo);
}
