package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Desconto;

public interface DescontoRepository extends JpaRepository<Desconto, Integer>{

}
