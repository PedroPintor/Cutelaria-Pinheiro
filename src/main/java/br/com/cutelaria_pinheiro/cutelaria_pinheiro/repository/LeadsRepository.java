package br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Leads;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, UUID>  {
    Optional<Leads> findByID(UUID id);
}
