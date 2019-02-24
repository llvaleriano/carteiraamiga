package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCarteira")
    @SequenceGenerator(name = "generatorCarteira", sequenceName = "sqIdCarteira")
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @Column(length = 30)
    private String nome;

    @Column(length = 2000)
    private String descricao;

    @OneToMany
    private List<Ativo> ativos;
}
