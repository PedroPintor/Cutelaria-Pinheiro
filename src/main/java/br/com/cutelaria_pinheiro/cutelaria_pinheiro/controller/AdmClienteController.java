package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ClienteService;

@Controller
@RequestMapping("/administrador/clientes")
public class AdmClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<Cliente> clientes = clienteService.findAll();
        List<Cliente> sortedClientes = clientes.stream()
                .sorted((cliente1, cliente2) -> cliente1.getNome().compareTo(cliente2.getNome()))
                .collect(Collectors.toList());
        model.addAttribute("clientes", sortedClientes);
        return "adm-clientes";
    }

    @GetMapping("/adicionar")
    public String adicionar(ModelMap model) {
        model.addAttribute("cliente", new Cliente());
        return "/inserirCliente";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente, ModelMap modelMap) {
        try {
            clienteService.salvar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("error", "Erro ao salvar o cliente.");
            return "/inserirCliente";
        }
        return "redirect:/administrador/clientes/listar";
    }
}
