package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ClienteService;

@Controller
@RequestMapping("/administrador/clientes")
public class AdmClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/listar")
    public String listar(ModelMap model){
        List<Cliente> produtos = clienteService.findAll();
        List<Cliente> sortedClientes = produtos.stream()
                .sorted((produto1, produto2) -> produto1.getNome().compareTo(produto2.getNome()))
                .collect(Collectors.toList());
        model.addAttribute("clientes", sortedClientes);
        return "/adm-clientes";
    }
}
