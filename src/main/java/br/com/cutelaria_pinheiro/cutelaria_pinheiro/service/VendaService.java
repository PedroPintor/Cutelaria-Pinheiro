package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Venda;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public Venda criarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda buscarVendaPorId(UUID id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public void deletarVenda(UUID id) {
        vendaRepository.deleteById(id);
    }

} 