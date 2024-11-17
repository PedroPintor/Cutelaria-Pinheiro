package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "bdd_venda", schema = "CUTELARIA")
public class Venda {

    @Id
    @Basic
    @Column(name = "ID_VENDA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoQuantidade> produtos;

    public Venda() {
        this.produtos = new ArrayList<>();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoQuantidade> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(UUID produtoId, int quantidade) {
        this.produtos.add(new ProdutoQuantidade(produtoId, quantidade));
    }

    
    // Classe interna para representar a relação entre produto e quantidade
    
    @Entity
    public static class ProdutoQuantidade {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "ID_VENDA")
        private Venda venda;

        private UUID produtoId;
        private int quantidade;

        public ProdutoQuantidade(UUID produtoId, int quantidade) {
            this.produtoId = produtoId;
            this.quantidade = quantidade;
        }

        // Getters e Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public UUID getProdutoId() {
            return produtoId;
        }

        public void setProdutoId(UUID produtoId) {
            this.produtoId = produtoId;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }
} 