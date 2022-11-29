package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.HistoricoTransacoesProduto;

public interface HistoricoTranasacoesProdutoRepository extends JpaRepository<HistoricoTransacoesProduto, Long>{

}
