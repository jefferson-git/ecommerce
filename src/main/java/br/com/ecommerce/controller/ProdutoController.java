package br.com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ecommerce.dto.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ProdutoController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Produto correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<ProdutoDto> findById(@PathVariable Long id);

	@GetMapping
	@Operation(summary = "Retorna Produto em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<Page<ProdutoDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable);

	@PostMapping
	@Operation(summary = "Método responsável por criar Produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<ProdutoDto> create(@Valid @RequestBody ProdutoDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<ProdutoDto> update(@PathVariable Long id, @Valid @RequestBody ProdutoDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Produto pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Long id);
	
	@GetMapping("/nome")
	@Operation(summary = "Retorna Produto correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<ProdutoDto>> findByNomeProduto(String nome);
	
	@GetMapping("/nome-contem")
	@Operation(summary = "Retorna Produto correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<ProdutoDto>> findByNomeProdutoContaining(String nome);
	
	@GetMapping("/codigo")
	@Operation(summary = "Retorna Produto correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<ProdutoDto>> findByCodigoProduto(String codigo);
}
