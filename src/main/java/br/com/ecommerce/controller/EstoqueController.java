package br.com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ecommerce.dto.EstoqueDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EstoqueController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Estoque correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<EstoqueDto> findById(@PathVariable Long id);

	@GetMapping
	@Operation(summary = "Retorna Estoque em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<EstoqueDto>> findAll();

	@PostMapping
	@Operation(summary = "Método responsável por criar Estoque")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<EstoqueDto> create(@Valid @RequestBody EstoqueDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Estoque")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<EstoqueDto> update(@PathVariable Long id, @Valid @RequestBody EstoqueDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Estoque pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Long id);
	
	@GetMapping("/codigo")
	@Operation(summary = "Retorna Estoque do Produto correspondente a busca por código do produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<EstoqueDto>> findByCodigoEstoqueProduto(String codigo);
}
