package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.MargemLucroController;
import br.com.ecommerce.dto.MargemLucroDto;
import br.com.ecommerce.service.implement.MargemLucroServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/margem-lucros")
public class MargemLucroControllerImpl implements MargemLucroController{

	private final MargemLucroServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<MargemLucroDto> findById(Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), MargemLucroDto.class));
	}
	
	@Override
	public ResponseEntity<List<MargemLucroDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map(obj -> model.mapper().map(obj, MargemLucroDto.class)).collect(Collectors.toList()));
	}
	
	@Override
	public ResponseEntity<MargemLucroDto> create(MargemLucroDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), MargemLucroDto.class).getId()).toUri()).build();
	}
	
	@Override
	public ResponseEntity<MargemLucroDto> update(Integer id, MargemLucroDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), MargemLucroDto.class));
	}
	
	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
