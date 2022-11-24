package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.UnidadeMedidaDto;
import br.com.ecommerce.model.UnidadeMedida;
import br.com.ecommerce.repository.UnidadeMedidaRepository;
import br.com.ecommerce.service.UnidadeMedidaService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.Menssage;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnidadeMedidaServiceImpl implements UnidadeMedidaService{

	private final UnidadeMedidaRepository repository;
	private final ModelMapperConfig model;
	@Override
	public UnidadeMedida findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Unidade de medida não encontrado com id:"+ id));
	}

	@Override
	public List<UnidadeMedida> findAll() {
		return repository.findAll();
	}

	@Override
	public UnidadeMedida create(UnidadeMedidaDto dto) {
		
		for (UnidadeMedida medida : repository.findAll()) {
			if(medida.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Essa unidade de medida já foi cadastrada!");
			
			if(medida.getDescricao().equalsIgnoreCase(dto.getDescricao()))				
				throw new DataIntegrityViolationException("Essa descrição já foi cadastrada!");	
		}
		
		dto.setDataCriacao(new Date());
		return repository.save(model.mapper().map(dto, UnidadeMedida.class));
	}

	@Override
	public UnidadeMedida update(Integer id, UnidadeMedidaDto dto) {
		
		var unidadeMedida = findById(id);
		
		for (UnidadeMedida medida : repository.findAll()) {
			if(medida.getNome().equalsIgnoreCase(dto.getNome()) && medida.getDescricao().equalsIgnoreCase(dto.getDescricao()) && medida.getId() != id) 
				throw new DataIntegrityViolationException("Essas informações pertencem a outro cadastrada!");
		
			if(medida.getNome().equalsIgnoreCase(dto.getNome()) && medida.getDescricao().equalsIgnoreCase(dto.getDescricao()) && medida.getId() == id)
				throw new Menssage("Não houve alteração nos campos!");	
		}
		
		dto.setDataCriacao(unidadeMedida.getDataCriacao());
		dto.setDataAtualizacao(new Date());
		dto.setId(id);
		return repository.save(model.mapper().map(dto, UnidadeMedida.class));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(findById(id));
		
	}
}
