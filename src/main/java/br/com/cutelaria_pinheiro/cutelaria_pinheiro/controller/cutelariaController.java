package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cutelaria-pinheiro")
public class cutelariaController {


    // pagina principal
    @GetMapping(" ")
    public String index(){
        return "/index";
    }

    // pagina de facas 
    @GetMapping("/facas")
    public String pag_facas(){
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

    

}
