package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ClienteService;
import jakarta.validation.Valid;

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
        return "/adm-clientes";
    }


    // pagina para adicionar um novo cliente 
    @GetMapping("/adicionar")
    public String adicionar(ModelMap model) {
        model.addAttribute("cliente", new Cliente());
        return "/inserirCliente";
    }

    // salvar um novo cliente
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


    //  pagina para remover o cliente
    @GetMapping("/remover/{id}")
    public String remover(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("cliente", clienteService.findCliente(id));
        return "/removerCliente";
    }

    // excluir cliente
    @PostMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            if(uuid != null){
                clienteService.deleteById(uuid);
            }
        } catch (IllegalArgumentException e) {
            // Se a string não for um UUID válido, você pode tratar o erro aqui
            System.out.println("erro : " + e.getMessage());
            return "redirect:/administrador/clientes/listar";
        }
        return "redirect:/administrador/clientes/listar";
    }

    // pagina de ediçao do cliente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, ModelMap model)  {
        model.addAttribute("cliente", clienteService.findCliente(id));

        return "/editarCliente";
    }

    // na pagina de ediçao , esse metodo ira salvar as atulalizaçoes
    @PostMapping("/atualizar")
    public String atualizar(@Valid @ModelAttribute Cliente cliente,
            BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "/editarCliente";
        }
        clienteService.salvar(cliente);
        return "redirect:/administrador/clientes/listar";
    }

    
}
