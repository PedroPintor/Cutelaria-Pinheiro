package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cutelo;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.CuteloRepository;

@Service
public class CuteloService {
    
    @Autowired
    private CuteloRepository cuteloRepository;

    public List<Cutelo> findAll() {
        return cuteloRepository.findAll();
    }

    public Cutelo findById(UUID id) {
        return cuteloRepository.findById(id).orElse(null);
    }

    public List<Cutelo> findByCategoria(String categoria) {
        return cuteloRepository.findByCategoria(categoria);
    }

    public Cutelo salvar(Cutelo cutelo) {
        return cuteloRepository.save(cutelo);
    }

    public void deleteById(UUID id) {
        cuteloRepository.deleteById(id);
    }
}
