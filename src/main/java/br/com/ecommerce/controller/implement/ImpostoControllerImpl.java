package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.ImpostoController;
import br.com.ecommerce.dto.ImpostoDto;
import br.com.ecommerce.service.implement.ImpostoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/impostos")
public class ImpostoControllerImpl implements ImpostoController{

	private final ImpostoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<ImpostoDto> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), ImpostoDto.class));
	}

	@Override
	public ResponseEntity<List<ImpostoDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map(obj -> model.mapper().map(obj, ImpostoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<ImpostoDto> create(ImpostoDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), ImpostoDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<ImpostoDto> update(Integer id, ImpostoDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), ImpostoDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
