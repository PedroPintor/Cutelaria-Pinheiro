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
@Table( name = "bdd_produto", schema = "PRODUTOS")
public class Produto {
    

    @Id
    @Basic
    @Column( name = "ID_PRODUTO")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID ID;
    
    @Column( name = "NOME")
    private String nome;

    @Column( name = "CATEGORIA")
    private int categoria;

    // metodos
    

}
