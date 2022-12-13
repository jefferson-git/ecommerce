package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.ProdutoDto;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.repository.ProdutoRepository;
import br.com.ecommerce.service.ProdutoService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

	private final ProdutoRepository repository;
	private final ModelMapperConfig model;
	
	@Override
	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado com o id:" + id));
	}

	@Override
	public Page<Produto> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Produto create(ProdutoDto dto) {
		
		for (Produto produto : repository.findAll()) {
			if(produto.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Produto já cadastrado com esse nome!");
			
			if(produto.getCodigo().equals(dto.getCodigo()))
				throw new DataIntegrityViolationException("Código de barras vinculado a outro produto!");
			
			if(produto.getDescricao().equals(dto.getDescricao()))
				throw new DataIntegrityViolationException("Descrição informada já esta vinculado a outro produto!");
		}
	
		dto.setDataCadastro(new Date());
		return repository.save(model.mapper().map(dto, Produto.class));
	}

	@Override
	public Produto update(Long id, ProdutoDto dto) {
		
		var produtoRecuperado = findById(id);
		dto.setId(id);
		dto.setDataAtualizacao(new Date());
		dto.setDataCadastro(produtoRecuperado.getDataCadastro());
		
		for (Produto prod : repository.findAll()) {
			if(prod.getNome().equals(dto.getNome()) && id != prod.getId())
				throw new DataIntegrityViolationException("Produto já cadastrado com esse nome!");
			
			if(prod.getCodigo().equals(dto.getCodigo()) && id != prod.getId())
				throw new DataIntegrityViolationException("Código de barras vinculado a outro produto!");
		}
		
		return repository.save(model.mapper().map(dto, Produto.class));
	}

	@Override
	public void delete(Long id) {
		repository.delete(findById(id));
	}

	@Override
	public List<Produto> findByNomeProduto(String nome) {
		
		var produtos = repository.findByNome(nome);		
		if(produtos.isEmpty())
			throw new Menssage("Não há produto cadastrado com esse nome : "+ nome);
		
		return produtos;
	}

	@Override
	public List<Produto> findByNomeProdutoContaining(String nome) {

		var produtos = repository.findByNomeContaining(nome);		
		if(produtos.isEmpty())
			throw new Menssage("Não há produto cadastrado que contenha essa : "+ nome);
		
		return produtos;
	}

	@Override
	public List<Produto> findByCodigoProduto(String codigo) {
		
		var produtos = repository.findByCodigo(codigo);		
		if(produtos.isEmpty())
			throw new Menssage("Não há produto cadastrado com esse código : "+ codigo);
		
		return produtos;
	}
}
