package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Madeira;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.MadeiraRepository;

@Service
public class MadeiraService {
    
    @Autowired
    private MadeiraRepository madeiraRepository;

    public List<Madeira> findAll(){
        return madeiraRepository.findAll();
    }

    public Optional<Madeira> findById(UUID id){
        return madeiraRepository.findById(id);
    }

    public Madeira salvar(Madeira madeira){
        return madeiraRepository.save(madeira);
    }

    public void deletar(UUID id){
        madeiraRepository.deleteById(id);
    }
    
}
