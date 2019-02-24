package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorUsuario")
    @SequenceGenerator(name = "generatorUsuario", sequenceName = "sqIdUsuario")
    private Long id;
    private String nome;
    private String documento;
    private String senha;
}
