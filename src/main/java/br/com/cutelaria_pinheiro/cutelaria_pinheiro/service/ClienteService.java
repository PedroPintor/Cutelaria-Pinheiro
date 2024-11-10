package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente); 
    }

    public Optional<Cliente> findCliente(UUID id){
        return clienteRepository.findById(id);
    }

    public void deleteById(UUID id){
        clienteRepository.deleteById(id);
    }
}
