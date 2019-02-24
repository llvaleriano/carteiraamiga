package br.com.vl.carteiraamiga.web;

import br.com.vl.carteiraamiga.application.InvestimentoService;
import br.com.vl.carteiraamiga.web.dto.AcaoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/acao")
public class AcaoResource {

    @Autowired
    private InvestimentoService investimentoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "acoes/{sigla}", method = RequestMethod.GET, produces = "application/json")
    public List<AcaoDto> pesquisarAcaoPorSigla(@PathVariable @NotNull String sigla) {
        return investimentoService.listarAcoesPorSigla(sigla)
                .stream()
                .map(a -> modelMapper.map(a, AcaoDto.class))
                .collect(Collectors.toList());
    }

}
