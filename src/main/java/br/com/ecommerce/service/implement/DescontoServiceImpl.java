package br.com.ecommerce.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.dto.DescontoDto;
import br.com.ecommerce.model.Desconto;
import br.com.ecommerce.repository.DescontoRepository;
import br.com.ecommerce.service.DescontoService;
import br.com.ecommerce.service.exception.DataIntegrityViolationException;
import br.com.ecommerce.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DescontoServiceImpl implements DescontoService{

	private DescontoRepository repository;
	private ModelMapperConfig model;
	
	@Override
	public Desconto findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Desconto não encontrado com o id:" + id));
	}

	@Override
	public List<Desconto> findAll() {
		return repository.findAll();
	}

	@Override
	public Desconto create(DescontoDto dto) {
		
		for (Desconto desconto : repository.findAll() ) {
			if(desconto.getDescricao().equalsIgnoreCase(dto.getDescricao()))
				throw new DataIntegrityViolationException("Essa descrição já foi cadastrada!");
		}
		
		dto.setDataCriacao(new Date());
		return repository.save(model.mapper().map(dto, Desconto.class));
	}

	@Override
	public Desconto update(Integer id, DescontoDto dto) {
		
		var desconto = findById(id);
		for (Desconto descontos : repository.findAll()) {
			if(descontos.getDescricao().equalsIgnoreCase(dto.getDescricao()) && id != descontos.getId())
				throw new DataIntegrityViolationException("Essa descrição pertence a outro cadastro!");
			
			if(descontos.getDescricao().equalsIgnoreCase(dto.getDescricao()) && id == descontos.getId())
				throw new DataIntegrityViolationException("Não houve mudanças nos campos!");
		}
		
		dto.setDataAtualizacao(new Date());
		dto.setDataCriacao(desconto.getDataCriacao());
		dto.setId(id);
		return repository.save(model.mapper().map(dto, Desconto.class));
	}

	@Override
	public void delete(Integer id) {
		repository.delete(findById(id));		
	}
}
