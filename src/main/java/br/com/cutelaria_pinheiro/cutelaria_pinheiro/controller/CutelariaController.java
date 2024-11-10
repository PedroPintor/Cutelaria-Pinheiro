package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;

@Controller
@RequestMapping("/cutelaria-pinheiro")
public class CutelariaController {

    @Autowired
    private ProdutoService produtoService;

    private final String CATEGORIA_FACA = "faca de churrasco";

    // pagina principal
    @GetMapping("")
    public String index(){
        return "/index";
    }

    // pagina de facas 
    @GetMapping("/facas")
    public String pag_facas(ModelMap model){
        model.addAttribute("produtos", produtoService.findAllFacas(CATEGORIA_FACA));
        return "/facas";
    }

    // pagina de cutelos
    @GetMapping("/cutelos")
    public String pag_cutelos(){
        return "/cutelos";
    }

    // pagina de tabuas
    @GetMapping("/tabuas")
    public String pag_tabuas(){
        return "/tabuas";
    }

    // página de comentários
    @GetMapping("/comentarios")
    public String pag_comentarios(){
        return "/comentarios-OutroGrupo";
    }

    // página de vitrine
    @GetMapping("/vitrine")
    public String pag_vitrine(){
        return "/vitrine-OutroGrupo";
    }

}
