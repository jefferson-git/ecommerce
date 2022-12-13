package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.dto.EstoqueDto;
import br.com.ecommerce.model.Estoque;
import br.com.ecommerce.model.Perca;
import br.com.ecommerce.repository.EstoqueRepository;
import br.com.ecommerce.service.EstoqueService;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstoqueServiceImpl implements EstoqueService{

	private final EstoqueRepository estoqueRepository;
	private final ProdutoServiceImpl produtoServiceImpl;
	private final ModelMapperConfig model;
	 	
	@Override
	public Estoque findById(Long id) {
		return estoqueRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não há estoque com esse id:"+ id));
	}

	@Override
	public List<Estoque> findAll() {
		return estoqueRepository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Estoque create(CompraDto compraDto, EstoqueDto estoqueDto) {		

		for(Estoque estoqueRecuperado : estoqueRepository.findAll()) {
			if(estoqueRecuperado.getCodigoProduto().equals(compraDto.getCodigoProduto())) {		
				estoqueRecuperado.setQuantidadeTotalEmEstoque(compraDto.getQuantidade() + estoqueRecuperado.getQuantidadeTotalEmEstoque());
				return estoqueRepository.save(model.mapper().map(estoqueDto, Estoque.class));
			}
		}
		
		estoqueDto.setDataDeEntrada(new Date());
		estoqueDto.setDataDeFabricacao(compraDto.getDataDeFabricacao());
		estoqueDto.setDataDeVencimento(compraDto.getDataDeValidade());
		estoqueDto.setNomeProduto(compraDto.getNomeProduto());
		estoqueDto.setCodigoProduto(compraDto.getCodigoProduto());
		estoqueDto.setQuantidadePorCompra(compraDto.getQuantidade());
		estoqueDto.setQuantidadeTotalEmEstoque(compraDto.getQuantidade());		
		return estoqueRepository.save(model.mapper().map(estoqueDto, Estoque.class));		
	}

	@Override
	@Transactional
	public void update(Perca perca, Estoque estoque) {				
		
		for(Estoque estoqueRecuperado : estoqueRepository.findAll()) {
			if(estoqueRecuperado.getCodigoProduto().equals(perca.getCodigoProduto()))
				if(perca.getQuantidade() > estoqueRecuperado.getQuantidadeTotalEmEstoque())
					throw new Menssage("Quantidade informada de perca esta incoreta, pois não há essa quantidade de produto no estoque!");
				
				estoqueRecuperado.setQuantidadeTotalEmEstoque(estoqueRecuperado.getQuantidadeTotalEmEstoque() - perca.getQuantidade());
				estoqueRepository.save(estoqueRecuperado);
			}
		}
	
	@Override 
	public void delete(Long id) {
		estoqueRepository.delete(findById(id));		
	}

	@Override
	public List<Estoque> findByCodigoProdutoEstoque(String codigo) {
		
		var estoqueRecuperado = estoqueRepository.findByCodigoProduto(codigo);
		if(estoqueRecuperado.isEmpty())
			throw new Menssage("Não há este prouto com esse código no estoque!");
		return estoqueRecuperado;
	}
}
