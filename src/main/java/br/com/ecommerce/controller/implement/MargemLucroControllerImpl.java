package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	private MargemLucroServiceImpl service;
	private ModelMapperConfig model;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<MargemLucroDto> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), MargemLucroDto.class));
	}
	
	@Override
	@GetMapping
	public ResponseEntity<List<MargemLucroDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map(obj -> model.mapper().map(obj, MargemLucroDto.class)).collect(Collectors.toList()));
	}
	
	@Override
	@PostMapping
	public ResponseEntity<MargemLucroDto> create(@Valid @RequestBody MargemLucroDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), MargemLucroDto.class).getId()).toUri()).build();
	}
	
	@Override
	@PutMapping("/{id}")
	public ResponseEntity<MargemLucroDto> update(@PathVariable Integer id, @Valid @RequestBody MargemLucroDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), MargemLucroDto.class));
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
