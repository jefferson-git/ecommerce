package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
