package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.ProdutoHeranca;

@Repository
public interface ProdutoHerancaRepository extends JpaRepository<ProdutoHeranca, UUID> {
    
}
