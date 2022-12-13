package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

}
