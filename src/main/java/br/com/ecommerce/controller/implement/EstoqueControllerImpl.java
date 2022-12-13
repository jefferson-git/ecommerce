package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.EstoqueController;
import br.com.ecommerce.dto.EstoqueDto;
import br.com.ecommerce.service.implement.EstoqueServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/estoques")
public class EstoqueControllerImpl implements EstoqueController{

	private final EstoqueServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<EstoqueDto> findById(Long id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), EstoqueDto.class));
	}

	@Override
	public ResponseEntity<List<EstoqueDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().
				map(obj -> model.mapper().map(obj, EstoqueDto.class)).collect(Collectors.toList()));
	}

//	@Override
//	public ResponseEntity<EstoqueDto> create(EstoqueDto dto) {
//		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}"). 
//				buildAndExpand(model.mapper().map(service.create(dto), EstoqueDto.class).getId()).toUri()).build();
//	}
//
//	@Override
//	public ResponseEntity<EstoqueDto> update(Long id, @RequestBody EstoqueDto dto) {
//		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), EstoqueDto.class));
//	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<EstoqueDto> create(@Valid EstoqueDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<EstoqueDto> update(Long id, @Valid EstoqueDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<EstoqueDto>> findByCodigoEstoqueProduto(String codigo) {
		return ResponseEntity.ok().body(service.findByCodigoProdutoEstoque(codigo).stream().
				map(obj -> model.mapper().map(obj, EstoqueDto.class)).collect(Collectors.toList()));
	}
}
