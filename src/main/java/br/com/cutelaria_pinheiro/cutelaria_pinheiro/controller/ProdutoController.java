package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;

@Controller
@RequestMapping("/cutelaria-pinheiro/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    // parte do cliente

    // visualizar produto faca
    @GetMapping("/informacoes")
    public String informacoesFaca(Model model){
        // model.addAttribute("produto", new Produto() );
        // produtoService.get_produto( model);

        return "/informacoes/faca";
    }

    // visualizar produto cutelo
    public String informacoesCutelo(){
        return "/informacoes/cutelo";
    }

    // visualizar produto tabuas
    public String informacoesTabua(){
        return "/informacoes/tabua";
    }


    // parte do administrador


}
