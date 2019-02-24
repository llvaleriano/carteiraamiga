package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Acao extends Ativo {

    private String sigla;

    @OneToMany
    @JoinColumn(name = "idAtivo")
    private List<Cotacao> cotacoes;

}
