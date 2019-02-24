package br.com.vl.carteiraamiga.web.dto;

import br.com.vl.carteiraamiga.domain.TipoOperacao;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdemDto {

    private Long id;
    private Date data;
    private Long idAtivo;
    private BigDecimal valor;
    private TipoOperacao tipoOperacao;

}
