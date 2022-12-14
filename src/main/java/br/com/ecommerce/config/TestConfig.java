package br.com.ecommerce.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.model.Cidade;
import br.com.ecommerce.model.Estado;
import br.com.ecommerce.model.Imposto;
import br.com.ecommerce.model.Marca;
import br.com.ecommerce.model.MargemLucro;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.repository.CidadeRepository;
import br.com.ecommerce.repository.EstadoRepository;
import br.com.ecommerce.repository.ImpostoRepository;
import br.com.ecommerce.repository.MarcaRepository;
import br.com.ecommerce.repository.MargemLucroRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration 
@Profile("test")
public class TestConfig {

	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final CategoriaRepository categoriaRepository;
	private final MarcaRepository marcaRepository;
	private final MargemLucroRepository margemLucroRepository;
	private final ImpostoRepository impostoRepository;
	
	@Bean 
	public void CreateDados() {	
	
		Estado estado = new Estado(null, "Goiás", "GO", new Date(), null);
		estadoRepository.save(estado);
		
		Cidade cidade = new Cidade(null, "Goiânia", new Date(), estadoRepository.findById(1).get());
		cidadeRepository.save(cidade);
		
		Categoria categoria = new Categoria(null, "Bebidas", "todo tipo de bebidas", new Date(), null);
		categoriaRepository.save(categoria);
		
		Marca marca = new Marca(null, "ambev", new Date(), null);
		marcaRepository.save(marca);
		
		MargemLucro lucro = new MargemLucro(null, (float) 25.9, "produto importado", new Date(), null);
		margemLucroRepository.save(lucro);
		
		Imposto imposto = new Imposto(null, (float) 16.8, "imposto federal", new Date(), null);
		impostoRepository.save(imposto);
	} 
}
