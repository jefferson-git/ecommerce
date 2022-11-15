package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ecommerce.dto.CidadeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface CidadeController {

	@Operation(summary = "Retorna Cidade correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CidadeDto> findById(Integer id);

	@Operation(summary = "Retorna Cidade em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<CidadeDto>> findAll();

	@Operation(summary = "Método responsável por criar Cidade")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<CidadeDto> create(CidadeDto dto);
	
	@Operation(summary = "Método responsável por alterar Cidade")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<CidadeDto> update(Integer id, CidadeDto dto);

	@Operation(summary = "Método responsável por excluir Cidade pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(Integer id);
}
