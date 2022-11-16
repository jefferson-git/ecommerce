package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ecommerce.dto.CategoriaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CategoriaController {

	@Operation(summary = "Retorna Categoria correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CategoriaDto> findById(Integer id);

	@Operation(summary = "Retorna Categoria em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<CategoriaDto>> findAll();

	@Operation(summary = "Método responsável por criar Categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<CategoriaDto> create(CategoriaDto dto);
	
	@Operation(summary = "Método responsável por alterar Categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CategoriaDto> update(Integer id, CategoriaDto dto);

	@Operation(summary = "Método responsável por excluir Categoria pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(Integer id);
}
