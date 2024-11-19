package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Venda;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Pedido;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Produto;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.VendaService;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ClienteService;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/administrador/vendas")
public class AdmVendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("vendas", vendaService.listarVendas());
        return "adm/adm-vendas"; // Página para listar vendas
    }

    @GetMapping("/adicionar")
    public String adicionar(ModelMap model) {
        List<Cliente> clientes = clienteService.findAll(); // Certifique-se de que este método retorna a lista de clientes
        model.addAttribute("clientes", clientes);

        List<Produto> produtos = produtoService.findAll(); // Certifique-se de que este método retorna a lista de produtos
        model.addAttribute("produtos", produtos);

        model.addAttribute("venda", new Venda());
        // Adicione a lista de clientes e produtos ao modelo, se necessário
        return "adm/inserirVenda"; // Página para adicionar uma nova venda
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Venda venda, ModelMap model) {
        //  Aqui você deve processar a lista de produtos e quantidades
        // Exemplo: venda.adicionarProduto(produtoId, quantidade);
        try {
            // Salvar a venda
            vendaService.criarVenda(venda);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Erro ao salvar a venda.");
            return "adm/inserirVenda";
        }
        return "redirect:/administrador/vendas/listar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("venda", vendaService.buscarVendaPorId(id));
        return "adm/removerVenda"; // Página para confirmar a remoção
    }

    @PostMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable UUID id) {
        vendaService.deletarVenda(id);
        return "redirect:/administrador/vendas/listar";
    }

    // @PostMapping("/adicionarProduto/{vendaId}")
    // public String adicionarProduto(@PathVariable UUID vendaId, @RequestParam UUID produtoId, @RequestParam int quantidade) {
    //     vendaService.adicionarProdutoAVenda(vendaId, produtoId, quantidade);
    //     return "redirect:/administrador/vendas/listar"; // Redireciona para a lista de vendas após adicionar o produto
    // }


} 