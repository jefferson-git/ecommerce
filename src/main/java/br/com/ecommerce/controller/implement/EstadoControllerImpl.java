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
import br.com.ecommerce.controller.EstadoController;
import br.com.ecommerce.dto.EstadoDto;
import br.com.ecommerce.service.implement.EstadoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/estados")
public class EstadoControllerImpl implements EstadoController{

	private final EstadoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), EstadoDto.class));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<EstadoDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().map(obj -> model.mapper().map(obj, EstadoDto.class)).collect(Collectors.toList()));
	}

	@Override
	@PostMapping
	public ResponseEntity<EstadoDto> create(@Valid @RequestBody EstadoDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(model.mapper().map(service.create(dto), EstadoDto.class).getId()).toUri()).build();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<EstadoDto> update(@PathVariable Integer id,@RequestBody EstadoDto dto){
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), EstadoDto.class));
	}

	@Override
	public ResponseEntity<EstadoDto> updateAll(Integer id, EstadoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
