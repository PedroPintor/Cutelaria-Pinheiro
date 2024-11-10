package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/administrador/produtos")
public class AdmProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<Produto> produtos = produtoService.findAll();
        List<Produto> sortedProdutos = produtos.stream()
                .sorted((produto1, produto2) -> produto1.getNome().compareTo(produto2.getNome()))
                .collect(Collectors.toList());
        model.addAttribute("produtos", sortedProdutos);
        return "adm-produtos";
    }

    @PostMapping("/salvar")
    public String salvar(Produto model, @RequestParam("file") MultipartFile file, ModelMap modelMap) {
        try {
            if (file.getSize() > 2 * 1024 * 1024) { // 2 MB
                modelMap.addAttribute("error", "O tamanho do arquivo não pode exceder 2 MB.");
                return "/inserirProduto";
            }

            if (!file.isEmpty()) {
                model.setFoto(file.getBytes());
            }
            produtoService.salvar(model);
        } catch (IOException e) {
            e.printStackTrace();
            modelMap.addAttribute("error", "Erro ao processar o arquivo.");
            return "/inserirProduto";
        }
        return "redirect:/administrador/produtos/listar";
    }

    @GetMapping("/adicionar")
    public String inserir(ModelMap model) {
        model.addAttribute("produto", new Produto());
        return "/inserirProduto";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("produto", produtoService.findById(id));
        return "/padrao/remover";
    }

    // pagina de ediçao do produto
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, ModelMap model) throws UnsupportedEncodingException {
        model.addAttribute("produto", produtoService.findById(id));
        
        byte[] imageBytes = produtoService.findImage(id);
        if (imageBytes != null) {
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            model.addAttribute("image", base64Image);
        }
        return "/editarProduto";
    }

    // na pagina de ediçao , esse metodo ira salvar as atulalizaçoes
    @PostMapping("/atualizar")
    public String atualizar(@Valid @ModelAttribute Produto produto,
            BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("produto", produto);
            return "/editarProduto";
        }
        produtoService.salvar(produto);
        return "redirect:/administrador/produtos/listar";
    }

    
}
