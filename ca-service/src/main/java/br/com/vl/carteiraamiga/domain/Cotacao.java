package br.com.vl.carteiraamiga.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCotacao")
    @SequenceGenerator(name = "generatorCotacao", sequenceName = "sqIdCotacao")
    private Long id;
    private Date data;
    private BigDecimal valor;

}
