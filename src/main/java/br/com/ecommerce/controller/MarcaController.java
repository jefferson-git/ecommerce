package br.com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ecommerce.dto.MarcaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MarcaController {

	@Operation(summary = "Retorna Marca correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MarcaDto> findById(Long id);

	@Operation(summary = "Retorna Marca em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<MarcaDto>> findAll();

	@Operation(summary = "Método responsável por criar Marca")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<MarcaDto> create(MarcaDto dto);
	
	@Operation(summary = "Método responsável por alterar Marca")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MarcaDto> update(Long id, MarcaDto dto);

	@Operation(summary = "Método responsável por excluir Marca pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(Long id);
}
