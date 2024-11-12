package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

import java.util.Base64;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "bdd_madeira", schema = "CUTELARIA")
public class Madeira {

    @Id
    @Basic
    @Column(name = "ID_MADEIRA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    @Column(name = "ACABAMENTO")
    private String acabamento;

    @Column(name = "COMPRIMENTO")
    private String comprimento;

    @Column(name = "LARGURA")
    private String largura;

    @Column(name = "ESPESSURA")
    private String espessura;

    @Column(name = "MATERIAL")
    private String material;



    // metodos
    public UUID getId() {
        return id;
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

    
    public byte[] getFoto() {
        return foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public String getFotoBase() {
        if (foto != null) {
            return Base64.getEncoder().encodeToString(foto);
        }
        return null; // ou uma string vazia, dependendo da sua necessidade
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getEspessura() {
        return espessura;
    }

    public void setEspessura(String espessura) {
        this.espessura = espessura;
    }

}
