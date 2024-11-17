package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Madeira;

@Repository
public interface MadeiraRepository extends JpaRepository<Madeira, UUID>{
    
    List<Madeira> findByCategoria(String categoria);
}
