package br.com.ecommerce.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.EstadoDto;
import br.com.ecommerce.model.Estado;
import br.com.ecommerce.repository.EstadoRepository;
import br.com.ecommerce.service.EstadoService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadoServiceImpl implements EstadoService{

	private final EstadoRepository repository;
	private final ModelMapperConfig model;	

	@Override
	public Estado findById(Integer id) {
		return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Estado não encontrado, com id:"+id ));
	}

	@Override
	public List<Estado> findAll() {
		return repository.findAll();
	}

	@Override
	public Estado create(EstadoDto dto) {
		
		if(dto.getSigla().length() <= 1 || dto.getSigla().length() > 2 )
			throw new DataIntegrityViolationException("Sigla deve possuir duas letras!");

		for (Estado estado : repository.findAll()) 
			if(estado.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Estado já cadastrado!");
		
		return repository.save(model.mapper().map(dto, Estado.class));
	}

	@Override
	public Estado update(Integer id,EstadoDto dto) {
		dto.setId(findById(id).getId());
		return repository.save(model.mapper().map(dto, Estado.class));
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(findById(id).getId());
	}
}
