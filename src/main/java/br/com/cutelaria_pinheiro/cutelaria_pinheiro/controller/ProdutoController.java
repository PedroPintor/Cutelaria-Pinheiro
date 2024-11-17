package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;





import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.MadeiraService;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cutelaria-pinheiro/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MadeiraService madeiraService;


    // pagina de facas e cutelos
    @GetMapping("/metal")
    public String pag_metal(ModelMap model){
        model.addAttribute("produtos", produtoService.findAll());
        
        return "index/vitrine-metal";
    }
    
    // mostrar as informaçoes do produto selecionado
    @GetMapping("/metal/informacao/{id}")
    public String informacoes_produto(@PathVariable UUID id, ModelMap model ){   
        try{
            model.addAttribute("produto", produtoService.findById(id));
            
        }catch(Exception e){
            System.out.println("erro: " + e.getMessage());
            return "redirect:/cutelaria-pinheiro/produtos/metal";
        }
        
        return "index/informacoes-produto-metal";
    }

    /*
    *  FALTA FAZER A PAGINA PARA OS PRODUTOS DE MADEIRA  
    */

    // pagina de produtos feitos com madeira
    @GetMapping("/madeira")
    public String pag_madeira(ModelMap model){
        model.addAttribute("madeiras", madeiraService.findAll());

        return "index/vitrine-madeira";
    }

    // mostrar as informaçoes do produto de madeira selecionado
    @GetMapping("/madeira/inforcao/{id}")
    public String infomacoes_madeira(@PathVariable UUID id, ModelMap model){
        try {
            model.addAttribute("madeira", madeiraService.findById(id));
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/cutelaria-pinheiro/produtos/madeira";
        }
        return "index/inforcoes-produto-madeira";
    }


    @PostMapping("/filtros")
    public String aplicarFiltro(@RequestParam("descricao") String categoria, ModelMap model ) {
        try {
            List<Produto> produtos = produtoService.findByCategoria(categoria);
            if ( produtos.isEmpty()) {
                model.addAttribute("mensagem", "Nenhum produto encontrado para a categoria: " + categoria);
            }
            model.addAttribute("produtos", produtos);
        } catch (Exception e) {
            System.err.println("Erro ao aplicar filtro: " + e.getMessage());
            model.addAttribute("mensagem", "Ocorreu um erro ao buscar os produtos.");
        }
        return "index/vitrine-metal";
    }
    

}
