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
@Table( name = "bdd_clientes",schema = "CUTELARIA")
public class Cliente {
    
    @Id
    @Basic
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "ID_CLIENTE")
    private UUID id;

    @Column(name = "NOME", length = 20, nullable = false)
    private String nome;

    @Column(name = "DATA_DE_NASCIMENTO", nullable = false)
    private String dataDeNascimento;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "WHATSAPP", nullable = false, unique = true)
    private String whatsapp;

    @Column(name = "JA_COMPROU")
    private String jaComprou;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getJa_comprou() {
        return jaComprou;
    }

    public void setJa_comprou(String ja_comprou) {
        this.jaComprou = ja_comprou;
    }

}
