package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.leadsRepository;

@Service
public class leadsService {
    
    @Autowired
    private leadsRepository leadsRepository;

    


}
