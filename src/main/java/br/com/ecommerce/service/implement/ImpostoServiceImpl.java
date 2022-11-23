package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.ImpostoDto;
import br.com.ecommerce.model.Imposto;
import br.com.ecommerce.repository.ImpostoRepository;
import br.com.ecommerce.service.ImpostoService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpostoServiceImpl implements ImpostoService{

	private ImpostoRepository repository;
	private ModelMapperConfig model;
	
	@Override
	public Imposto findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Imposto não encontrado com o id:"+id));
	}

	@Override
	public List<Imposto> findAll() {
		return repository.findAll();
	}

	@Override
	public Imposto create(ImpostoDto dto) {
		
		for (Imposto imposto : repository.findAll()) {
			if(imposto.getDescricao().equalsIgnoreCase(dto.getDescricao()))
				throw new DataIntegrityViolationException("Descrição já cadastrada!");
		}
		
		dto.setDataCriacao(new Date());
		return repository.save(model.mapper().map(dto, Imposto.class));
	}

	@Override
	public Imposto update(Integer id, ImpostoDto dto) {
		
		var imposto = findById(id);
		for (Imposto imp : repository.findAll()) {
			
			if(imp.getDescricao().equals(dto.getDescricao()) && id != imp.getId())
				throw new DataIntegrityViolationException("Descrição pertence a outro cadastro!");
			
			else if(imp.getDescricao().equalsIgnoreCase(dto.getDescricao()) && imp.getId() != id)
			throw new DataIntegrityViolationException("Indentificador invalido, pertence a outro cadastro!");
			
			if(imp.getDescricao().equalsIgnoreCase(dto.getDescricao()) && imp.getId() == id 
					&& imp.getPorcentagem().floatValue() == dto.getPorcentagem().floatValue())
			throw new Menssage("Não houve alteração nos campos!");				
		}
		
		dto.setId(id);
		dto.setDataAtualizacao(new Date());
		dto.setDataCriacao(imposto.getDataCriacao());		
		return repository.save(model.mapper().map(dto, Imposto.class));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(findById(id));		
	}

}
