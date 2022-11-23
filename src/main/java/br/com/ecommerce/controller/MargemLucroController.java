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

import br.com.ecommerce.dto.MargemLucroDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MargemLucroController {

	@GetMapping("/{id}")
	@Operation(summary = "Retorna Margem de Lucro correspondente ao identificador recuperado por parametro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MargemLucroDto> findById(@PathVariable Integer id);

	@GetMapping
	@Operation(summary = "Retorna lista Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<List<MargemLucroDto>> findAll();

	@PostMapping
	@Operation(summary = "Método responsável por criar Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "devolvera no headers do request o caminho de acesso")})
	ResponseEntity<MargemLucroDto> create(@Valid @RequestBody MargemLucroDto dto);
	
	@PutMapping("/{id}")
	@Operation(summary = "Método responsável por alterar Margem de Lucro")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
	ResponseEntity<MargemLucroDto> update(@PathVariable Integer id, @Valid @RequestBody MargemLucroDto dto);

	@DeleteMapping("/{id}")
	@Operation(summary = "Método responsável por excluir Margem de Lucro pelo id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Não retorna nada!")})
	ResponseEntity<Void> delete(@PathVariable Integer id);
}
