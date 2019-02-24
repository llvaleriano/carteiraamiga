package br.com.vl.carteiraamiga.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorOrdem")
    @SequenceGenerator(name = "generatorOrdem", sequenceName = "sqIdOrdem")
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date data;

    @OneToOne
    @JoinColumn(name = "idAtivo")
    private Ativo ativo;

    private BigDecimal valor;

    @OneToOne
    private Corretora corretora;

    @Column
    private BigDecimal taxas;

    @Enumerated
    private TipoOperacao tipoOperacao;
}
