package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.model.HistoricoCustoProduto;
import br.com.ecommerce.repository.HistoricoCustoProdutoRepository;
import br.com.ecommerce.service.HistoricoCustoProdutoService;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class HistoricoCustoProdutoServiceImpl implements HistoricoCustoProdutoService{

	private final HistoricoCustoProdutoRepository repository;
	
	@Override
	public HistoricoCustoProduto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Não existe Histórico de custo com esse id:" + id));
	}

	@Override	
	public Page<HistoricoCustoProduto> findAll(Pageable pageable) {
		
		var paginacao = repository.findAll(pageable);
		if(paginacao.isEmpty())
			throw new Menssage("Não há histórico de custo cadastrado!");
		
		return paginacao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public HistoricoCustoProduto create(CompraDto dto, HistoricoCustoProduto historico) {	
		
		for (HistoricoCustoProduto historicoRecuperado : repository.findAll()) 
			if(historicoRecuperado.getCodigoProduto().equals(dto.getCodigoProduto()) 
					&& historicoRecuperado.getPrecoCusto().doubleValue() == dto.getValorUnitario().doubleValue()) {
				return repository.save(historicoRecuperado);				
			}		
		
		historico.setDataDoHistorico(new Date());
		historico.setNomeProduto(dto.getNomeProduto());
		historico.setPrecoCusto(dto.getValorUnitario());
		historico.setCodigoProduto(dto.getCodigoProduto());
		return repository.save(historico);
	 }

	@Override
	public void delete(Long id) {
		repository.delete(findById(id));
	}

	@Override
	public List <HistoricoCustoProduto> findByNomeProdutoHistorico(String nome) {

		var historico = repository.findByNomeProduto(nome);
		if(historico.isEmpty())
			throw new Menssage("Não há histórico de custo cadastrado com esse nome!");

		return historico;
	}

	@Override
	public List<HistoricoCustoProduto> findByNomeProdutoContainingHistorico(String nome) {
		
		var historico = repository.findByNomeProdutoContaining(nome);
		if(historico.isEmpty())
			throw new Menssage("Não há histórico de custo cadastrado com esse nome!");

		return historico;
	}

	@Override
	public List<HistoricoCustoProduto> findByCodigoProdutoHistorico(String codigo) {
		
		var historico = repository.findByCodigoProduto(codigo);
		if(historico.isEmpty())
			throw new Menssage("Não há histórico de custo cadastrado com esse código de barras!");

		return historico;
	}

}
