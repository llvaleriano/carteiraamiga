package br.com.vl.carteiraamiga.application;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CotacaoService {

    private Logger logger = LoggerFactory.getLogger(CotacaoService.class);
    private static final String KEY = "9WKF20RWM6RUBZ9V";
    private static final int TIMEOUT = 3000;

    public IntraDay getCotacaoIntraday(String papel, Interval intervalo) {
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(KEY, TIMEOUT);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);

        try {
            return stockTimeSeries.intraDay(papel, intervalo, OutputSize.COMPACT);
        } catch (AlphaVantageException e) {
            logger.error("Erro ao buscar cotação intraday para o papel {0}", papel, e);
        }
        return null;
    }


    //TODO
    //Criar objetos java para representar o retorno da consulta das cotações
    //Criar os metodos de consulta para dia, semana e mês
    //Converter os horários para o timezone do Brasil
    //Tratar erros se o serviço alpavantage estiver indisponível
    //Tratar erros quando o usuário passar um papel inexistente
}
