package br.com.ecommerce.service.implement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.PercaDto;
import br.com.ecommerce.model.Estoque;
import br.com.ecommerce.model.Perca;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.PercaRepository;
import br.com.ecommerce.service.PercaService;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PercaServiceImpl implements PercaService{

	
	private final PercaRepository compraRepository;
	private final ProdutoServiceImpl produtoServiceImpl;
	private final EstoqueServiceImpl estoqueServiceImpl;
	private final PercaRepository percaRepository;
	private final ModelMapperConfig model;
	
	@Override
	public Perca findById(Integer id) {
		return compraRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado perca com o id:" + id));
	}

	@Override
	public Page<Perca> findAll(Pageable pageable) {
		
		var compras = compraRepository.findAll(pageable);
		if(compras.isEmpty())
			throw new Menssage("Não há registros perca no sistema!");
		
		return compras;
	}

	@Override 
	@Transactional(rollbackFor = Exception.class)
	public Perca create(PercaDto dto) {		
		
		produtoServiceImpl.findByCodigoProduto(dto.getCodigoProduto());
		var perca  = percaRepository.save(model.mapper().map(dto, Perca.class));
		estoqueServiceImpl.update(perca, new Estoque());
		return perca;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Perca update(Integer id, PercaDto dto) {
		
		dto.setId(findById(id).getId()); 		
		produtoServiceImpl.findByCodigoProduto(dto.getCodigoProduto()); 
		var perca  = percaRepository.save(model.mapper().map(dto, Perca.class));
		estoqueServiceImpl.update(perca, new Estoque());
		return perca;
	} 

	@Override
	public void delete(Integer id) {
		compraRepository.delete(findById(id));		
	}

	@Override
	public List<Produto> findByCodigoProduto(String codigo) {		
		return produtoServiceImpl.findByCodigoProduto(codigo);		
	}
}
