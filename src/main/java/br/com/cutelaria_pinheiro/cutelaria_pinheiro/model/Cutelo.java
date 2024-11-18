package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

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
@Table(name = "bdd_cutelo", schema = "CUTELARIA")
public class Cutelo {
    
    @Id
    @Basic
    @Column( name = "ID_PRODUTO")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column( name = "NOME")
    private String nome;

    @Column( name = "CATEGORIA")
    private String categoria;

    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    
    @Column( name = "MATERIAL_LAMINA")
    private String material_Lamina;

    @Column( name = "MATERIAL_CABO")
    private String materia_cabo;

    @Column( name = "COMP_LAMINA")
    private String comp_lamina;

    @Column( name = "DORSO")
    private String dorso;

    @Column( name = "COMP_TOTAL")
    private String comp_total;

    @Column( name = "LARG_LAMINA")
    private String larg_lamina;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getMaterial_Lamina() {
        return material_Lamina;
    }

    public void setMaterial_Lamina(String material_Lamina) {
        this.material_Lamina = material_Lamina;
    }

    public String getMateria_cabo() {
        return materia_cabo;
    }

    public void setMateria_cabo(String materia_cabo) {
        this.materia_cabo = materia_cabo;
    }

    public String getComp_lamina() {
        return comp_lamina;
    }

    public void setComp_lamina(String comp_lamina) {
        this.comp_lamina = comp_lamina;
    }

    public String getDorso() {
        return dorso;
    }

    public void setDorso(String dorso) {
        this.dorso = dorso;
    }

    public String getComp_total() {
        return comp_total;
    }

    public void setComp_total(String comp_total) {
        this.comp_total = comp_total;
    }

    public String getLarg_lamina() {
        return larg_lamina;
    }

    public void setLarg_lamina(String larg_lamina) {
        this.larg_lamina = larg_lamina;
    }

    

}
