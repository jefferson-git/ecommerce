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
import br.com.ecommerce.dto.CategoriaDto;
import br.com.ecommerce.service.implement.CategoriaServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaControllerImpl {
	
	private final CategoriaServiceImpl service;
	private final ModelMapperConfig model;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), CategoriaDto.class));
	}
	
	@GetMapping
	public ResponseEntity <List<CategoriaDto>> findAll(){
		return ResponseEntity.ok().body(service.findAll().stream().
				map(obj -> model.mapper().map(obj, CategoriaDto.class)).collect(Collectors.toList()));
	}
	
	@PostMapping()
	public ResponseEntity<CategoriaDto> create(@Valid @RequestBody CategoriaDto dto){
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
				buildAndExpand(model.mapper().map(service.create(dto), CategoriaDto.class).getId()).toUri()).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @RequestBody CategoriaDto dto){
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), CategoriaDto.class));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
