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
@Table(name = "bdd_leads", schema = "LEADS")
public class Leads {
    // ATRIBUTOS

    @Id
    @Basic
    @Column( name = "ID_LEAD")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID ID;

    @Column( name = "NOME", nullable = false, length = 20)
    private String nome;

    @Column( name = "WHATSAPP", nullable = false, unique = true)
    private int whatsapp;

    // metodos

    public UUID get_id() {
        return this.ID;
    }

    public String get_nome() {
        return this.nome;
    }

    public int get_whatsapp() {
        return this.whatsapp;
    }

    public void set_id(UUID id) {
        this.ID = id;
    }

    public void set_nome( String nome) {
        this.nome = nome;
    }

    public void set_whatsapp( int numero) {
        this.whatsapp = numero;
    }
}
