package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.MargemLucroDto;
import br.com.ecommerce.model.MargemLucro;
import br.com.ecommerce.repository.MargemLucroRepository;
import br.com.ecommerce.service.MargemLucroService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MargemLucroServiceImpl implements MargemLucroService{

	private MargemLucroRepository repository;
	private ModelMapperConfig model;
	
	@Override
	public MargemLucro findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Margem de lucro não encontrada com o id:"+id));
	}

	@Override
	public List<MargemLucro> findAll() {
		return repository.findAll();
	}

	@Override
	public MargemLucro create(MargemLucroDto dto) {
		
		for(MargemLucro margem : repository.findAll()) 
			if(margem.getDescricao().equalsIgnoreCase(dto.getDescricao()))
				throw new DataIntegrityViolationException("Essa descrição já foi cadastrada");	
		
		dto.setDataCriacao(new Date());				
		return repository.save(model.mapper().map(dto, MargemLucro.class));
	}

	@Override
	public MargemLucro update(Integer id, MargemLucroDto dto) {		
		
		var margem = findById(id);		 
		for(MargemLucro lucro : repository.findAll()){
			
			if(lucro.getDescricao().equalsIgnoreCase(dto.getDescricao()) && id != lucro.getId())
				throw new DataIntegrityViolationException("Essa descrição já foi cadastrada");
			
			if(lucro.getDescricao().equalsIgnoreCase(dto.getDescricao()) && lucro.getId() != id)
				throw new DataIntegrityViolationException("Indentificador invalido, pertence a outro cadastro!");
			
			if(lucro.getDescricao().equalsIgnoreCase(dto.getDescricao()) && lucro.getId() == id && lucro.getValor().floatValue() == dto.getValor().floatValue())
			throw new Menssage("Não houve alteração nos campos!");
		}
		
		dto.setId(id);
		dto.setDataAtualizacao(new Date());
		dto.setDataCriacao(margem.getDataCriacao());
		return repository.save(model.mapper().map(dto, MargemLucro.class));
	}

	@Override 
	public void delete(Integer id) {
		repository.delete(findById(id));		
	}
}
