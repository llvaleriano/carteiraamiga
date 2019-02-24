package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class Corretora {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCorretora")
    @SequenceGenerator(name = "generatorCorretora", sequenceName = "sqIdCorretora")
    private Long id;
    private String nome;

    @OneToOne
    private Usuario usuario;
}
