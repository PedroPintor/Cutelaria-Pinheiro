package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;

@Controller
@RequestMapping("/administrador/produtos")
public class AdmProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<Produto> produtos = produtoService.findAll();
        List<Produto> sortedProdutos = produtos.stream()
                .sorted((produto1, produto2) -> produto1.getNome().compareTo(produto2.getNome()))
                .collect(Collectors.toList());
        model.addAttribute("produtos", sortedProdutos);
        return "adm-produtos";
    }

    @PostMapping("/salvar")
    public String salvar(Produto model) {
        produtoService.salvar(model);
        return "redirect:/administrador/produtos/listar";
    }

     // inserir Foto do Produto
     @GetMapping("/adicionar")
     public String inserir(ModelMap model) {
        model.addAttribute("produto", new Produto());
        return "inserirProduto";
     }


 
}
