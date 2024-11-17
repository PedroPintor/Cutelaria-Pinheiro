package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {
    // Métodos adicionais podem ser definidos aqui, se necessário
} 