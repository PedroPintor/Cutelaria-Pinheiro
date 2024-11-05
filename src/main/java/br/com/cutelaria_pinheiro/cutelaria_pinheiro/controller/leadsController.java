package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cutelaria-pinheiro/leads")
public class leadsController {
    
    // formulario leads
    @GetMapping("/formulario")
    public String formulario(){
        return "/leads/formulario";
    }

    // salvar leads
    // @PostMapping("/salvar")
    // public 
}
