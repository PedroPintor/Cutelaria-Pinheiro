package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Leads;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cutelaria-pinheiro/leads")
public class LeadsController {
    @Autowired
    private LeadsService leadsService;
    
    // formulario leads
    @GetMapping("/formulario")
    public String formulario(Model model){
        model.addAttribute("leads", new Leads());
        
        return "/leads/formulario";
    }

    // salvar leads
    @PostMapping("/salvar")
    public String salvar(Leads leads) {
        leadsService.save(leads);
        
        return "/leads/sucesso";
    }
}
