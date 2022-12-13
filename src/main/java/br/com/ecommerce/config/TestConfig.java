package br.com.ecommerce.config;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ecommerce.dto.CompraDto;
import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.model.Cidade;
import br.com.ecommerce.model.Compra;
import br.com.ecommerce.model.Desconto;
import br.com.ecommerce.model.Endereco;
import br.com.ecommerce.model.Estado;
import br.com.ecommerce.model.FormaPagamento;
import br.com.ecommerce.model.HistoricoCustoProduto;
import br.com.ecommerce.model.Imposto;
import br.com.ecommerce.model.Marca;
import br.com.ecommerce.model.MargemLucro;
import br.com.ecommerce.model.Perca;
import br.com.ecommerce.model.Produto;
import br.com.ecommerce.model.UnidadeMedida;
import br.com.ecommerce.repository.CategoriaRepository;
import br.com.ecommerce.repository.CidadeRepository;
import br.com.ecommerce.repository.CompraRepository;
import br.com.ecommerce.repository.DescontoRepository;
import br.com.ecommerce.repository.EnderecoRepository;
import br.com.ecommerce.repository.EstadoRepository;
import br.com.ecommerce.repository.EstoqueRepository;
import br.com.ecommerce.repository.FormaPagamentoRepository;
import br.com.ecommerce.repository.HistoricoCustoProdutoRepository;
import br.com.ecommerce.repository.ImpostoRepository;
import br.com.ecommerce.repository.MarcaRepository;
import br.com.ecommerce.repository.MargemLucroRepository;
import br.com.ecommerce.repository.PercaRepository;
import br.com.ecommerce.repository.ProdutoRepository;
import br.com.ecommerce.repository.UnidadeMedidaRepository;
import br.com.ecommerce.service.implement.CompraServiceImpl;
import br.com.ecommerce.service.implement.HistoricoCustoProdutoServiceImpl;
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
	private final EnderecoRepository enderecoRepository;
	private final UnidadeMedidaRepository medidaRepository;
	private final DescontoRepository descontoRepository;
	private final FormaPagamentoRepository formaPagamentoRepository;
	private final ProdutoRepository produtoRepository;
	private final CompraServiceImpl compraServiceImpl;
	private final PercaRepository percaRepository;
	
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
		
		Endereco endereco = new Endereco(null, "74.330-070", "rua 12", "casa 02", "23", "centro", "sim", new Date(), null, cidadeRepository.findById(1).get());
		enderecoRepository.save(endereco);
		
		UnidadeMedida medida = new UnidadeMedida(null, "CX2", "CAIXA COM 2 UNIDADES", new Date(), null);
		medidaRepository.save(medida);
		
		Desconto desconto = new Desconto(null, (float) 15.5, "cliente com cupom", new Date(), null);
		descontoRepository.save(desconto);	
		
		FormaPagamento pagamento = new FormaPagamento(null, "boleto", "pagamento atraves de boleto bancario", new Date(), null);
		formaPagamentoRepository.save(pagamento);
		
		Produto p1 = new Produto(null, "coca cola 2l", "7894900011517", null, BigDecimal.valueOf(7.45) , BigDecimal.valueOf(9.50), null, "coca cola de 2 lt", new Date(), new Date(), new Date(), null, desconto, lucro, categoria, imposto, medida, marca);
		produtoRepository.save(p1);
		
		Produto p2 = new Produto(null, "Sprit 2l", "7894900681000", null, BigDecimal.valueOf(5.99) , BigDecimal.valueOf(7.25), null, "sprit de 2 lt", new Date(), new Date(), new Date(), null, desconto, lucro, categoria, imposto, medida, marca);
		produtoRepository.save(p2);
		
		CompraDto compra1 = new CompraDto(null, 2, p1.getNome(), BigDecimal.valueOf(5.99), p1.getCodigo(), new Date(), new Date(), new Date());
		compraServiceImpl.create(compra1);
		
		CompraDto compra2 = new CompraDto(null, 3, p2.getNome(), BigDecimal.valueOf(7.49), p2.getCodigo(), new Date(), new Date(), new Date());
		compraServiceImpl.create(compra2);
		
		Perca perca = new Perca(null, p1.getNome(), 1 , p1.getPrecoCusto(), p1.getCodigo(), "sem gás", new Date());
		percaRepository.save(perca);
		
	} 
}
