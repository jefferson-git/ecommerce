package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
