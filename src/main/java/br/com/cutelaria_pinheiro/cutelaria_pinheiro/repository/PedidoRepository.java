package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID>{
    
}
