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

import br.com.ecommerce.dto.UnidadeMedidaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


public interface UnidadeMedidaController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Unidade de Medida correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<UnidadeMedidaDto> findById(@PathVariable Integer id);

	@GetMapping
	@Operation(summary = "Retorna Unidade de Medida em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<UnidadeMedidaDto>> findAll();

	@PostMapping
	@Operation(summary = "Método responsável por criar Unidade de Medida")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<UnidadeMedidaDto> create(@Valid @RequestBody UnidadeMedidaDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Unidade de Medida")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<UnidadeMedidaDto> update(@PathVariable Integer id,@Valid @RequestBody UnidadeMedidaDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Unidade de Medida pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Integer id);
}
