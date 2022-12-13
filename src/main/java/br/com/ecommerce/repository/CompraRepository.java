package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
