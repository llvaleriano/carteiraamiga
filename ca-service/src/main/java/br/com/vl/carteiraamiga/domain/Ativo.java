package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAtivo")
    @SequenceGenerator(name = "generatorAtivo", sequenceName = "sqIdAtivo")
    protected Long id;

    protected String nome;

    //TODO enum {Ação, Fundos, Renda Fixa, FII, Moeda, BDR, ETF}
    //protected String classe;
}
