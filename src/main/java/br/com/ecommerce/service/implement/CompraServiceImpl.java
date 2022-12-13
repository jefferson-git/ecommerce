package br.com.ecommerce.service.implement;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.dto.EstoqueDto;
import br.com.ecommerce.model.Compra;
import br.com.ecommerce.model.HistoricoCustoProduto;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.CompraRepository;
import br.com.ecommerce.service.CompraService;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompraServiceImpl implements CompraService{

	private final HistoricoCustoProdutoServiceImpl historicoCustoProdutoServiceImpl;
	private final CompraRepository compraRepository;
	private final ProdutoServiceImpl produtoServiceImpl;
	private final EstoqueServiceImpl estoqueServiceImpl;
	private final ModelMapperConfig model;
	
	@Override
	public Compra findById(Integer id) {
		return compraRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado essa compra com o id:" + id));
	}

	@Override
	public Page<Compra> findAll(Pageable pageable) {
		
		var compras = compraRepository.findAll(pageable);
		if(compras.isEmpty())
			throw new Menssage("Não há registros de compra!");
		
		return compras;
	}

	@Override
	@Transactional
	public Compra create(CompraDto dto) {		
		
		// verifica se o produto está cadastrado antes de salvar a compra.
		produtoServiceImpl.findByCodigoProduto(dto.getCodigoProduto());
			
		var compra = compraRepository.save(model.mapper().map(dto, Compra.class));
		historicoCustoProdutoServiceImpl.create(dto, new HistoricoCustoProduto());
		estoqueServiceImpl.create(dto, new EstoqueDto());
		return compra;
	}

	@Override
	public Compra update(Integer id, CompraDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		compraRepository.delete(findById(id));		
	}

	@Override
	public List<Produto> findByNomeContaining(String nome) {
		return produtoServiceImpl.findByCodigoProduto(nome);
	}

}
