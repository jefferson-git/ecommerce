package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.PercaController;
import br.com.ecommerce.dto.PercaDto;
import br.com.ecommerce.dto.ProdutoDto;
import br.com.ecommerce.service.implement.PercaServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/percas")
public class PercaControllerImpl implements PercaController{
	
	private final PercaServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<PercaDto> findById(Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), PercaDto.class));
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<Page<PercaDto>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(model.mapper().map(service.findAll(pageable), Page.class));
	}

	@Override
	public ResponseEntity<PercaDto> create(PercaDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), PercaDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<PercaDto> update(Integer id, @Valid PercaDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), PercaDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<List<ProdutoDto>> findByCodigoProduto(String codigo) {
		return ResponseEntity.ok().body(service.findByCodigoProduto(codigo).stream()
				.map(obj -> model.mapper().map(obj, ProdutoDto.class)).collect(Collectors.toList()));	}

}
