package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ecommerce.dto.HistoricoCustoProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface HistoricoCustoProdutoController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Historico de Custo do Produto correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<HistoricoCustoProdutoDto> findById(@PathVariable Long id);

	@GetMapping
	@Operation(summary = "Retorna Historico de Custo do Produto em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<Page<HistoricoCustoProdutoDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Historico de Custo do Produto pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Long id);
	
	@GetMapping("/nome")
	@Operation(summary = "Retorna Historico de Custo do Produto correspondente a busca por nome")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<HistoricoCustoProdutoDto>> findByNomeHistoricoCustoProduto(String nome);
	
	@GetMapping("/nome-contem")
	@Operation(summary = "Retorna Historico de Custo do Produto usando o like palavra chave contendo")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<HistoricoCustoProdutoDto>> findByNomeHistoricoCustoProdutoContaining(String nome);
	
	@GetMapping("/codigo")
	@Operation(summary = "Retorna Historico de Custo do Produto correspondente a busca por código do produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<HistoricoCustoProdutoDto>> findByCodigoHistoricoCustoProduto(String codigo);
}
