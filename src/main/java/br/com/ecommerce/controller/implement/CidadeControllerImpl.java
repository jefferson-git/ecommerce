package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

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
import br.com.ecommerce.controller.CidadeController;
import br.com.ecommerce.dto.CidadeDto;
import br.com.ecommerce.service.implement.CidadeServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cidades")
public class CidadeControllerImpl implements CidadeController{

	private final CidadeServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CidadeDto> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), CidadeDto.class));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<CidadeDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().
				map(obj -> model.mapper().map(obj, CidadeDto.class)).collect(Collectors.toList()));
	}

	@Override
	@PostMapping
	public ResponseEntity<CidadeDto> create( @RequestBody CidadeDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
				buildAndExpand(model.mapper().map(service.create(dto), CidadeDto.class).getId()).toUri()).build();
		}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<CidadeDto> update(@PathVariable Integer id, @RequestBody CidadeDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), CidadeDto.class));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
