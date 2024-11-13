package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Madeira;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.MadeiraService;

@Controller
@RequestMapping("/administrador/madeiras")
public class AdmMadeiraController {

    @Autowired
    private MadeiraService madeiraService;

    // listar os produtos de madeira e redirecionar para a pagina do adm
    @GetMapping("/listar")
    public String listar_madeiras(ModelMap model) {
        try {
            List<Madeira> madeiras = madeiraService.findAll();
            List<Madeira> sortedMadeiras = madeiras.stream()
                    .sorted((madeira1, madeira2) -> madeira1.getNome().compareTo(madeira2.getNome()))
                    .collect(Collectors.toList());
            model.addAttribute("madeiras", sortedMadeiras);
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/cutelaria-pinheiro";
        }
        return "adm-madeiras";
    }

    // inserir um novo produto de Maderia
    // pagina para inserir um novo produto
    @GetMapping("/adicionar")
    public String inserir_novo_produtoDeMadeira(ModelMap model) {
        try {
            model.addAttribute("madeira", new Madeira());
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "inserirMadeira";
    }

    // vai receber um requisiçao POST da pagina, e salvar no banco de dados
    @PostMapping("/salvar")
    public String adicionar_novo_produtoDeMadeira(Madeira madeira, @RequestParam("file") MultipartFile foto, 
                                                    ModelMap model) {
        try {
            if (!foto.isEmpty()){
                if (foto.getSize() > 2 * 1024 * 1024) { // 2 MB
                    model.addAttribute("error", "O tamanho do arquivo não pode exceder 2 MB.");
                    return "inserirMadeira";
                }
                madeira.setFoto(foto.getBytes());
            }
            
            madeiraService.salvar(madeira);
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "redirect:/administrador/madeiras/listar";
    }

    // remover um produto de madeira
    // pagina para confirmaçao de remoçao do produto
    @GetMapping("/remover/{id}")
    public String remover_madeira(@PathVariable UUID id, ModelMap model) {
        try {
            model.addAttribute("madeira", madeiraService.findById(id));
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "/removerMadeira";
    }

    // vai receber a requisiçao POST da pagina removerMadeira, para remover a
    // Madeira
    @PostMapping("/excluir/{id}")
    public String excluir_madeira(@PathVariable UUID id) {
        try {
            madeiraService.deletar(id);
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "redirect:/administrador/madeiras/listar";
    }

    // editar um produto de madeira
    // pagina para editar o produto de Madeira
    @GetMapping("/editar/{id}")
    public String editar_madeira(@PathVariable UUID id, ModelMap model) {
        try {
            model.addAttribute("madeira", madeiraService.findById(id));
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "/editarMadeira";
    }

    // requisiçao POST para salvar as alteraçoes
    @PostMapping("/atualizar")
    public String atualizar_madeira(Madeira madeira) {
        try {
            madeiraService.salvar(madeira);
        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
            return "redirect:/administrador/madeiras/listar";
        }
        return "redirect:/administrador/madeiras/listar";
    }

}
