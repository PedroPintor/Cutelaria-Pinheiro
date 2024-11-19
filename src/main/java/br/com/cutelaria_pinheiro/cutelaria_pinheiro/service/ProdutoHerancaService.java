package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.ProdutoHeranca;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.ProdutoHerancaRepository;

@Service
public class ProdutoHerancaService {
    
    @Autowired
    private ProdutoHerancaRepository produtoHerancaRepository;

    public List<ProdutoHeranca> listarTodosProdutos() {
        return produtoHerancaRepository.findAll();
    }

    public ProdutoHeranca buscarPorId(UUID id) {
        return produtoHerancaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}
