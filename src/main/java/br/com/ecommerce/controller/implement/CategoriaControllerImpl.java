package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.CategoriaController;
import br.com.ecommerce.dto.CategoriaDto;
import br.com.ecommerce.service.implement.CategoriaServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categorias")
public class CategoriaControllerImpl implements CategoriaController{
	
	private final CategoriaServiceImpl service;
	private final ModelMapperConfig model;

	public ResponseEntity<CategoriaDto> findById(Long id){
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), CategoriaDto.class));
	}
	
	@Override
	public ResponseEntity <List<CategoriaDto>> findAll(){
		return ResponseEntity.ok().body(service.findAll().stream().
				map(obj -> model.mapper().map(obj, CategoriaDto.class)).collect(Collectors.toList()));
	}
	
	@Override
	public ResponseEntity<CategoriaDto> create(CategoriaDto dto){
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
				buildAndExpand(model.mapper().map(service.create(dto), CategoriaDto.class).getId()).toUri()).build();
	}
	
	@Override
	public ResponseEntity<CategoriaDto> update(Long id, CategoriaDto dto){
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), CategoriaDto.class));
	}
	
	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
