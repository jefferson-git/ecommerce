package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.FormaPagamentoDto;
import br.com.ecommerce.model.FormaPagamento;
import br.com.ecommerce.repository.FormaPagamentoRepository;
import br.com.ecommerce.service.FormaPagamentoService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FormaPagamentoServiceImpl implements FormaPagamentoService{

	private final FormaPagamentoRepository repository;
	private final ModelMapperConfig model;
	
	@Override
	public FormaPagamento findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Forma de pagamento não encontrada com o id:"+id));
	}

	@Override
	public List<FormaPagamento> findAll() {
		return repository.findAll();
	}

	@Override
	public FormaPagamento create(FormaPagamentoDto dto) {
		
		for(FormaPagamento pagamento : repository.findAll()) {
			if(pagamento.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Essa forma de pagamento já foi cadastrada!");
			
		if(pagamento.getDescircao().equalsIgnoreCase(dto.getDescircao()))
			throw new DataIntegrityViolationException("Essa Descrição já foi cadastrada!");
		}
		
		dto.setDataCriacao(new Date());				
		return repository.save(model.mapper().map(dto, FormaPagamento.class));
	}

	@Override
	public FormaPagamento update(Integer id, FormaPagamentoDto dto) {		
		
		var margem = findById(id);		 
		for(FormaPagamento pagamento : repository.findAll()){
			
			if(pagamento.getNome().equalsIgnoreCase(dto.getNome()) && pagamento.getId() != id)
				throw new DataIntegrityViolationException("Indentificador invalido, pertence a outro cadastro!");
			
			if(pagamento.getNome().equalsIgnoreCase(dto.getNome()) && id != pagamento.getId())
				throw new DataIntegrityViolationException("Essa Forma de pagemento já foi cadastrada");
			
			if(pagamento.getDescircao().equalsIgnoreCase(dto.getDescircao()) && id != pagamento.getId())
				throw new DataIntegrityViolationException("Essa descrição já foi cadastrada");
			
			if(pagamento.getNome().equalsIgnoreCase(dto.getNome()) && pagamento.getId() == id && pagamento.getDescircao().equalsIgnoreCase(dto.getDescircao()))
			throw new Menssage("Não houve alteração nos campos!");
		}
		
		dto.setId(id);
		dto.setDataAtualizacao(new Date());
		dto.setDataCriacao(margem.getDataCriacao());
		return repository.save(model.mapper().map(dto, FormaPagamento.class));
	}

	@Override 
	public void delete(Integer id) {
		repository.delete(findById(id));		
	}
}
