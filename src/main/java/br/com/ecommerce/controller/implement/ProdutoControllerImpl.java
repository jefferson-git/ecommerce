package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.ProdutoController;
import br.com.ecommerce.dto.ProdutoDto;
import br.com.ecommerce.service.implement.ProdutoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoControllerImpl implements ProdutoController{

	private final ProdutoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<ProdutoDto> findById(Long id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), ProdutoDto.class));
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<Page<ProdutoDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok().body(model.mapper().map(service.findAll(pageable), Page.class));
	}

	@Override
	public ResponseEntity<ProdutoDto> create(ProdutoDto dto) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(model.mapper().map(service.create(dto), ProdutoDto.class).getId()).toUri()).build();
	}

	@Override
	public ResponseEntity<ProdutoDto> update(Long id, ProdutoDto dto) {
		return ResponseEntity.ok().body(model.mapper().map(service.update(id, dto), ProdutoDto.class));
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	} 

	@Override
	public ResponseEntity<List<ProdutoDto>> findByNomeProduto(String nome) {
		return ResponseEntity.ok().body(service.findByNomeProduto(nome).stream()
				.map(obj -> model.mapper().map(obj, ProdutoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<List<ProdutoDto>> findByNomeProdutoContaining(String nome) {
		return ResponseEntity.ok().body(service.findByNomeProdutoContaining(nome).stream()
				.map(obj -> model.mapper().map(obj, ProdutoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<List<ProdutoDto>> findByCodigoProduto(String codigo) {
		return ResponseEntity.ok().body(service.findByCodigoProduto(codigo).stream()
				.map(obj -> model.mapper().map(obj, ProdutoDto.class)).collect(Collectors.toList()));
	}
}
