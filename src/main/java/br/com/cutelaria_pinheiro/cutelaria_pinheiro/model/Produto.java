package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "bdd_produto", schema = "CUTELARIA")
public class Produto {
    

    @Id
    @Basic
    @Column( name = "ID_PRODUTO")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column( name = "NOME")
    private String nome;

    @Column( name = "CATEGORIA")
    private String categoria;

    
    // metodos
    
    public UUID getID() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setID(UUID iD) {
        this.id = iD;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
