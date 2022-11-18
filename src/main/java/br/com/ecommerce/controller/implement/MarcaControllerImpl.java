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
import br.com.ecommerce.controller.MarcaController;
import br.com.ecommerce.dto.MarcaDto;
import br.com.ecommerce.service.implement.MarcaServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/marcas")
public class MarcaControllerImpl implements MarcaController{

	private final MarcaServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<MarcaDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), MarcaDto.class));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<MarcaDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().
				map(obj -> model.mapper().map(obj, MarcaDto.class)).collect(Collectors.toList()));
	}

	@Override
	@PostMapping
	public ResponseEntity<MarcaDto> create(@Valid @RequestBody MarcaDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}"). 
				buildAndExpand(model.mapper().map(service.create(dto), MarcaDto.class).getId()).toUri()).build();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<MarcaDto> update(@Valid @PathVariable Long id, @RequestBody MarcaDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), MarcaDto.class));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
