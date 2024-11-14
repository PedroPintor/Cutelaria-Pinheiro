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
@Table( name = "bdd_usuarios", schema = "CUTELARIA")
public class User {
    
    @Id
    @Basic
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_usuario;

    @Column( name = "NOME")
    private String nome;

    @Column( name = "SNH")
    private String senha;

    @Column( name = "EMAIL")
    private String email;

    public UUID getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UUID id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
