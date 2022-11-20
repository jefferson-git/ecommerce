package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ecommerce.dto.MargemLucroDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MargemLucroController {

	@Operation(summary = "Retorna Margem de Lucro correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MargemLucroDto> findById(Integer id);

	@Operation(summary = "Retorna lista Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<MargemLucroDto>> findAll();

	@Operation(summary = "Método responsável por criar Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<MargemLucroDto> create(MargemLucroDto dto);
	
	@Operation(summary = "Método responsável por alterar Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MargemLucroDto> update(Integer id, MargemLucroDto dto);

	@Operation(summary = "Método responsável por excluir Margem de Lucro pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(Integer id);
}
