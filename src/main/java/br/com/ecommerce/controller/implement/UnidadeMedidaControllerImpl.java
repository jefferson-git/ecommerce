package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.UnidadeMedidaController;
import br.com.ecommerce.dto.UnidadeMedidaDto;
import br.com.ecommerce.service.implement.UnidadeMedidaServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/unidade-de-medidas")
public class UnidadeMedidaControllerImpl implements UnidadeMedidaController{

	private final UnidadeMedidaServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<UnidadeMedidaDto> findById(Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), UnidadeMedidaDto.class));
	}

	@Override
	public ResponseEntity<List<UnidadeMedidaDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map( obj -> model.mapper().map(obj, UnidadeMedidaDto.class)).collect(Collectors.toList()));

	}

	@Override
	public ResponseEntity<UnidadeMedidaDto> create(UnidadeMedidaDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), UnidadeMedidaDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<UnidadeMedidaDto> update(Integer id, UnidadeMedidaDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), UnidadeMedidaDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
