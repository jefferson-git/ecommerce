package br.com.ecommerce.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.model.Cidade;
import br.com.ecommerce.model.Estado;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.repository.CidadeRepository;
import br.com.ecommerce.repository.EstadoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@Profile("test")
public class TestConfig {

	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final CategoriaRepository categoriaRepository;
	
	@Bean 
	public void CreateDados() {	
	
		Estado estado = new Estado(null, "Goiás", "GO", new Date(), null);
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade(null, "Goiânia", new Date(), estadoRepository.findById(1).get());
		cidadeRepository.save(cidade);
		
		Categoria categoria = new Categoria(null, "Bebidas", "todo tipo de bebidas", new Date(), null);
		categoriaRepository.save(categoria);
	} 
}
