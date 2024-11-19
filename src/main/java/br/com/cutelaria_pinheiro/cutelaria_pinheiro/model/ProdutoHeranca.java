package br.com.cutelaria_pinheiro.cutelaria_pinheiro.model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class ProdutoHeranca {

    
} 
