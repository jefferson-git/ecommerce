package br.com.ecommerce.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ecommerce.model.Estado;
import br.com.ecommerce.repository.EstadoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@Profile("test")
public class TestConfig {

	private final EstadoRepository estadoRepository;
	
	@Bean 
	public void CreateDados() {	
	
		Estado estado = new Estado(null, "Goiás", "GO", new Date(), null);
		estadoRepository.save(estado);
	}
}
