package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.MarcaDto;
import br.com.ecommerce.model.Marca;
import br.com.ecommerce.repository.MarcaRepository;
import br.com.ecommerce.service.MarcaService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService{

	private MarcaRepository repository;
	private ModelMapperConfig model;
	
	@Override
	public Marca findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada com o id:"+id));
	}

	@Override
	public List<Marca> findAll() {
		return repository.findAll();
	}

	@Override
	public Marca create(MarcaDto dto) {		
		
		for (Marca marca : repository.findAll()) 
			if(marca.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Marca já registrada!");
		
		return repository.save(model.mapper().map(dto, Marca.class));
	}

	@Override
	public Marca update(Long id, MarcaDto dto) {
		
		for (Marca marca : repository.findAll()) {	
			
			if(marca.getNome().equalsIgnoreCase(dto.getNome()) && marca.getId() != id)
				throw new DataIntegrityViolationException("Indentificador invalido para essse registro!");
			
			if(marca.getNome().equalsIgnoreCase(dto.getNome()) && marca.getId() == id )
				throw new DataIntegrityViolationException("O nome não sofreu mudanças!");
		}
		
		var marca = findById(id);
		dto.setId(findById(id).getId());
		dto.setDataCriacao(marca.getDataCriacao());
		dto.setDataAtualizacao(new Date());

		return repository.save(model.mapper().map(dto, Marca.class));
	}

	@Override
	public void delete(Long id) {
		repository.delete(findById(id));	
	}

}
