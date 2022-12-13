package br.com.ecommerce.controller.implement;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.DescontoController;
import br.com.ecommerce.dto.DescontoDto;
import br.com.ecommerce.service.implement.DescontoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/descontos")
public class DescontoControllerImpl implements DescontoController{

	private final DescontoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<DescontoDto> findById(Integer id) {
		
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), DescontoDto.class)
				.add(linkTo(methodOn(DescontoControllerImpl.class).findById(id)).withRel("Lista-descontos")));
	}

	@Override 
	@GetMapping()
	public ResponseEntity<List<DescontoDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map( obj -> model.mapper().map(obj, DescontoDto.class)).collect(Collectors.toList()));

	}

	@Override
	public ResponseEntity<DescontoDto> create(DescontoDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), DescontoDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<DescontoDto> update(Integer id, DescontoDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), DescontoDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
