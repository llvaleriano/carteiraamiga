package br.com.vl.carteiraamiga;

import br.com.vl.carteiraamiga.application.InvestimentoService;
import br.com.vl.carteiraamiga.domain.Acao;
import br.com.vl.carteiraamiga.domain.Ordem;
import br.com.vl.carteiraamiga.domain.TipoOperacao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrdemTests {

    @Autowired
    private InvestimentoService investimentoService;

    @Test
    @Rollback
    public void inserirOrdemAcao() {
        Ordem ordem = new Ordem();
        ordem.setData(new Date());
        ordem.setValor(new BigDecimal("123.45"));
        ordem.setTipoOperacao(TipoOperacao.COMPRA);

        Acao acao = new Acao();
        acao.setId(1L);
        ordem.setAtivo(acao);

        Assert.assertTrue(ordem.getId() == null);
        investimentoService.salvarOrdem(ordem);
        Assert.assertTrue(ordem.getId() != null);
    }
}
