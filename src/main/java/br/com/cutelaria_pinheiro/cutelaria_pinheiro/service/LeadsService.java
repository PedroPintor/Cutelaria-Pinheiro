package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;


import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Leads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.LeadsRepository;
import java.util.Optional;
import java.util.UUID;

@Service
public class LeadsService {

    @Autowired
    LeadsRepository leadsRepository;

    public void save(Leads leads) {
        leadsRepository.save(leads);
    }
    
    public Optional<Leads> findByID(UUID id) {
        return leadsRepository.findByID(id);
    }

    


}
