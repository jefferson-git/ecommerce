package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
