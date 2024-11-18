package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cutelo; // Importar o modelo Cutelo
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.CuteloService; // Importar o serviço CuteloService

@Controller
@RequestMapping("/administrador/cutelos")
public class AdmCuteloController {
    @Autowired
    private CuteloService cuteloService; // Serviço para gerenciar cutelos

    @GetMapping("/home")
    public String home_admin() {
        return "adm/adm-home";
    }

    @GetMapping("/listar")
    public String listar_cutelo(ModelMap model) {
        model.addAttribute("cutelos", cuteloService.findAll()); // Listar todos os cutelos
        return "adm/adm-cutelos"; // Retornar a página de cutelos
    }

    @GetMapping("/adicionar")
    public String inserir(ModelMap model) {
        model.addAttribute("cutelo", new Cutelo()); // Adicionar um novo cutelo
        return "adm/inserirCutelo"; // Retornar a página de inserção
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cutelo cutelo) {
        cuteloService.salvar(cutelo); // Salvar o cutelo
        return "redirect:/administrador/cutelos/listar"; // Redirecionar para a lista
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("cutelo", cuteloService.findById(id)); // Editar cutelo
        return "adm/editarCutelo"; // Retornar a página de edição
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute Cutelo cutelo) {
        cuteloService.salvar(cutelo); // Atualizar o cutelo
        return "redirect:/administrador/cutelos/listar"; // Redirecionar para a lista
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("cutelo", cuteloService.findById(id)); // Remover cutelo
        return "adm/removerCutelo"; // Retornar a página de remoção
    }

    @PostMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable UUID id) {
        cuteloService.deleteById(id); // Confirmar exclusão do cutelo
        return "redirect:/administrador/cutelos/listar"; // Redirecionar para a lista
    }
}
