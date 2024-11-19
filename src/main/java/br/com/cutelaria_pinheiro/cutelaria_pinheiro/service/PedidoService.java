package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Cliente;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.ItemPedido;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.Pedido;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.ClienteRepository;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido criarPedido(UUID clienteId, List<ItemPedido> itens) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(LocalDate.now());
        pedido.setItens(itens);

        // Calcula o total do pedido
        double total = itens.stream().mapToDouble(ItemPedido::getSubTotal).sum();
        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }
}
