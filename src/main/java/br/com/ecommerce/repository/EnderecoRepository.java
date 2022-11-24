package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
