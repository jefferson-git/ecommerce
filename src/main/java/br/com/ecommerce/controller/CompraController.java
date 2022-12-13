package br.com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ecommerce.dto.CompraDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CompraController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Compra correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CompraDto> findById(@PathVariable Integer id);

	@GetMapping
	@Operation(summary = "Retorna Compra em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<Page<CompraDto>> findAll(Pageable pageable);

	@PostMapping
	@Operation(summary = "Método responsável por criar Compra")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<CompraDto> create(@Valid @RequestBody CompraDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Compra")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CompraDto> update(@PathVariable Integer id, @Valid @RequestBody CompraDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Compra pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Integer id);
	
	@GetMapping("/codigo")
	@Operation(summary = "Retorna Compra do Produto correspondente a busca por código do produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<CompraDto>> findByCodigoCompraProduto(String codigo);
}
