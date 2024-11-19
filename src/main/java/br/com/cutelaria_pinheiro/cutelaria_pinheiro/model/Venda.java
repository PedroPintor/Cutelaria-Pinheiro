package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bdd_venda", schema = "CUTELARIA")
public class Venda {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id_venda;

    private String data;

    private String total;

    @ManyToMany
    private ProdutoHeranca produto;

    @OneToMany
    private Cliente cliente;

    public UUID getId_venda() {
        return id_venda;
    }

    public void setId_venda(UUID id_venda) {
        this.id_venda = id_venda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ProdutoInterface getProduto() {
        return produto;
    }

    public void setProduto(ProdutoInterface produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

}