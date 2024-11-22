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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String atualizar(@ModelAttribute Cutelo cutelo, @RequestParam("file") MultipartFile file, ModelMap model) {
        try {
            // Verifica se um novo arquivo foi enviado
            if (!file.isEmpty()) {
                // Se um novo arquivo foi enviado, converta-o e defina a nova foto
                cutelo.setFoto(file.getBytes());
            } else {
                // Se nenhum novo arquivo foi enviado, mantenha a foto antiga
                // Aqui você pode buscar o cutelo existente do banco de dados para obter a foto antiga
                Cutelo cuteloExistente = cuteloService.findById(cutelo.getId());
                cutelo.setFoto(cuteloExistente.getFoto());
            }

            // Atualiza o cutelo no banco de dados
            cuteloService.salvar(cutelo);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Erro ao atualizar o cutelo.");
            return "adm/editarCutelo"; // Retorna para a página de edição em caso de erro
        }
        return "redirect:/administrador/cutelos/listar"; // Redireciona para a lista de cutelos
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
