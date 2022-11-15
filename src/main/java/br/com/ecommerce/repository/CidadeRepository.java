package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
