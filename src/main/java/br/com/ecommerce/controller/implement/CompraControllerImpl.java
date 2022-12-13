package br.com.ecommerce.controller.implement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.CompraController;
import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.service.implement.CompraServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/compras")
public class CompraControllerImpl implements CompraController{

	private final CompraServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<CompraDto> findById(Integer id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), CompraDto.class));
	}
 
	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<Page<CompraDto>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(model.mapper().map(service.findAll(pageable), Page.class));
	} 

	@Override
	public ResponseEntity<CompraDto> create(CompraDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), CompraDto.class).getId()).toUri()).build();
	}
	 
	@Override
	public ResponseEntity<CompraDto> update(Integer id, @Valid CompraDto dto) {
 
		return null;
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CompraDto>> findByCodigoCompraProduto(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
