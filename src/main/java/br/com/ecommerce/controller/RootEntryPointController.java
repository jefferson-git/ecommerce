package br.com.ecommerce.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.controller.implement.CategoriaControllerImpl;
import br.com.ecommerce.model.RootEntryPoint;

@RestController
public class RootEntryPointController {

	@GetMapping
	public RootEntryPoint root() {
		
		var model =  new RootEntryPoint();
		model.add(linkTo(methodOn(CategoriaControllerImpl.class).findAll()).withRel("Lista-categorias"));
		return model;
	}
}
