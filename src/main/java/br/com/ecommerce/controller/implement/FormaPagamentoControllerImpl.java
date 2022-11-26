package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.FormaPagamentoController;
import br.com.ecommerce.dto.FormaPagamentoDto;
import br.com.ecommerce.service.implement.FormaPagamentoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forma-de-pagamentos")
public class FormaPagamentoControllerImpl implements FormaPagamentoController{

	private final FormaPagamentoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<FormaPagamentoDto> findById(Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), FormaPagamentoDto.class));
	}

	@Override
	public ResponseEntity<List<FormaPagamentoDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream()
				.map(Obj -> model.mapper().map(Obj, FormaPagamentoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<FormaPagamentoDto> create(FormaPagamentoDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), FormaPagamentoDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<FormaPagamentoDto> update(Integer id, FormaPagamentoDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), FormaPagamentoDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
