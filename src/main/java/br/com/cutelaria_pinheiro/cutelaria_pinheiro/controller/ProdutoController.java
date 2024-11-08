package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;


    // visualizar informacao produto 
    // @GetMapping("/informacoes/{id}")
    // public String informacoesFaca(Model model) {
    //     model.addAttribute("produto", produtoService.findById(id) ); // ainda tem q arrumar

    //     return "redirect:/produto-informacao";
    // }



}
