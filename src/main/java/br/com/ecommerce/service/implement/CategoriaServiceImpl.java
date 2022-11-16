package br.com.ecommerce.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.CategoriaDto;
import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.service.CategoriaService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{

	private final CategoriaRepository repository;
	private final ModelMapperConfig model;

	@Override
	public Categoria findById(Long id) {
		return repository.findById(id).orElseThrow( ()-> new ObjectNotFoundException("Categoria não encontrada com id:"+id));
	}

	@Override
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Override
	public Categoria create(CategoriaDto dto) {
		return repository.save(model.mapper().map(dto, Categoria.class));
	}

	@Override
	public Categoria update(Long id, CategoriaDto dto) {
		
		for (Categoria categoria : repository.findAll()) 
			if(categoria.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Categoria já cadastrada com nome,"+dto.getNome());
		
		dto.setId(findById(id).getId());
		return repository.save(model.mapper().map(dto, Categoria.class));
	}

	@Override
	public void delete(Long id) {
		repository.delete(findById(id));		
	}
}
