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

import br.com.ecommerce.dto.MarcaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MarcaController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Marca correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MarcaDto> findById(@PathVariable Long id);

	@GetMapping
	@Operation(summary = "Retorna Marca em paginação a cada dez")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<MarcaDto>> findAll();

	@PostMapping
	@Operation(summary = "Método responsável por criar Marca")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<MarcaDto> create(@Valid @RequestBody MarcaDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Marca")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MarcaDto> update(@PathVariable Long id, @Valid @RequestBody MarcaDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Marca pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Long id);
}
