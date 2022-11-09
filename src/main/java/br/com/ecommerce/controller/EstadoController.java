package br.com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import br.com.ecommerce.dto.EstadoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EstadoController {

	@Operation(summary = "Retorna o Estado correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<EstadoDto> findById(Integer id);

	@Operation(summary = "Retorna o Estado em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<EstadoDto>> findAll();

	@Operation(summary = "Método responsável por criar Estado")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<EstadoDto> create(@Valid EstadoDto dto);

	@Operation(summary = "Método responsável por alterar um Estado por partes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<EstadoDto> update(Integer id, EstadoDto dto);
	
	@Operation(summary = "Método responsável por alterar um Estado")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<EstadoDto> updateAll(Integer id, EstadoDto dto);

	@Operation(summary = "Método responsável por excluir um Estado pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(Integer id);
}
