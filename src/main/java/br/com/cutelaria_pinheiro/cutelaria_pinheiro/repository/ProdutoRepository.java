package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, UUID> {
    
    List<Produto> findByCategoria(String categoria);
    
}
