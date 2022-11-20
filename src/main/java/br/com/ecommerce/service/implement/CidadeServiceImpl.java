package br.com.ecommerce.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.CidadeDto;
import br.com.ecommerce.model.Cidade;
import br.com.ecommerce.repository.CidadeRepository;
import br.com.ecommerce.service.CidadeService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CidadeServiceImpl implements CidadeService{

	private final CidadeRepository repository;
	private final EstadoServiceImpl serviceEstado;
	private final ModelMapperConfig model;

	@Override 
	public Cidade findById(Integer id) {
		return repository.findById(id).orElseThrow( ()-> new ObjectNotFoundException("Cidade não existe com o id:"+id));
	}

	@Override
	public List<Cidade> findAll() {
		return repository.findAll();
	}

	@Override
	public Cidade create(CidadeDto dto) {
		
		for (Cidade cidade : repository.findAll()) 
			if(cidade.getNome().equalsIgnoreCase(dto.getNome()))
				throw new DataIntegrityViolationException("Essa Cidade já foi cadastrada!");		
		
		dto.setEstado(serviceEstado.findById(dto.getEstado().getId()));
		return repository.save(model.mapper().map(dto, Cidade.class));
	}

	@Override
	public Cidade update(Integer id, CidadeDto dto) {
		dto.setId(id);
		var obj = findById(id);	
		dto.setDataCriacao(obj.getDataCriacao());
		serviceEstado.findById(dto.getEstado().getId());		
		return repository.save(model.mapper().map(dto, Cidade.class));
	}
 
	@Override
	public void delete(Integer id) {
		repository.delete(findById(id));		
	}
}
