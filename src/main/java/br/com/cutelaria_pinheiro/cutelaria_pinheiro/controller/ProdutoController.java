package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;




import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/cutelaria-pinheiro/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;


    // pagina de facas e cutelos
    @GetMapping("/metal")
    public String pag_facas(ModelMap model){
        model.addAttribute("produtos", produtoService.findAll());
        
        return "/vitrine-metal";
    }
    
    // mostrar as informaçoes do produto selecionado
    @GetMapping("/metal/informacao/{id}")
    public String informacoes_produto(@PathVariable UUID id, ModelMap model ){   
        try{
            model.addAttribute(" produto", produtoService.findById(id));
            return "/informacoes-produto-metal";
            
        }catch(Exception e){
            System.out.println("erro: " + e.getMessage());
            return "redirect:/cutelaria-pinheiro/produtos/metal";
        }
    }
    
    
    
}
