package br.com.ecommerce.controller.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.config.ModelMapperConfig;
import br.com.ecommerce.controller.HistoricoCustoProdutoController;
import br.com.ecommerce.dto.HistoricoCustoProdutoDto;
import br.com.ecommerce.service.implement.HistoricoCustoProdutoServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/historico-de-custo-de-produtos")
public class HistoricoCustoProdutoControllerImpl implements HistoricoCustoProdutoController{

	private final HistoricoCustoProdutoServiceImpl service;
	private final ModelMapperConfig model;
	
	@Override
	public ResponseEntity<HistoricoCustoProdutoDto> findById(Long id) {
		return ResponseEntity.ok().body(model.mapper().map(service.findById(id), HistoricoCustoProdutoDto.class));
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<Page<HistoricoCustoProdutoDto>> findAll(Pageable pageable) {
		return ResponseEntity.ok().body(model.mapper().map(service.findAll(pageable), Page.class));
	}

	@Override
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	} 

	@Override
	public ResponseEntity<List<HistoricoCustoProdutoDto>> findByNomeHistoricoCustoProduto(String nome) {
		return ResponseEntity.ok().body(service.findByNomeProdutoHistorico(nome).stream()
				.map(Obj -> model.mapper().map(Obj, HistoricoCustoProdutoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<List<HistoricoCustoProdutoDto>> findByNomeHistoricoCustoProdutoContaining(String nome) {
		return ResponseEntity.ok().body(service.findByNomeProdutoContainingHistorico(nome).stream()
				.map(Obj -> model.mapper().map(Obj, HistoricoCustoProdutoDto.class)).collect(Collectors.toList()));
	}

	@Override
	public ResponseEntity<List<HistoricoCustoProdutoDto>> findByCodigoHistoricoCustoProduto(String codigo) {
		return ResponseEntity.ok().body(service.findByCodigoProdutoHistorico(codigo).stream()
				.map(Obj -> model.mapper().map(Obj, HistoricoCustoProdutoDto.class)).collect(Collectors.toList()));
	}

}
