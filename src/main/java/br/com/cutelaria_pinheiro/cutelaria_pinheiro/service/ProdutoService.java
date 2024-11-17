package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto findById(UUID id){
        return produtoRepository.findById(id).orElse(null);
    }

    public byte[] findImage(UUID id){
        Produto produto = produtoRepository.findById(id).orElse(null);
        byte[] imagem = (produto != null) ? produto.getFoto() : null;
        
        return imagem;
    }

    public void deleteById(UUID id){
        produtoRepository.deleteById(id);
    }

    public List<Produto> findByCategoria(String categoria){
        return produtoRepository.findByCategoria(categoria);
    }

}
