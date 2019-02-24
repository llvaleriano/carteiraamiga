package br.com.vl.carteiraamiga.web;

import br.com.vl.carteiraamiga.CarteiraAmigaException;
import br.com.vl.carteiraamiga.application.InvestimentoService;
import br.com.vl.carteiraamiga.domain.Ativo;
import br.com.vl.carteiraamiga.domain.Ordem;
import br.com.vl.carteiraamiga.web.dto.OrdemDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ordem")
public class OrdemResource {

    private InvestimentoService investimentoService;
    private ModelMapper modelMapper;

    public OrdemResource(InvestimentoService investimentoService, ModelMapper modelMapper) {
        this.investimentoService = investimentoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody void inserirOrdem(@RequestBody OrdemDto ordemDto) {
        investimentoService.salvarOrdem(convertToEntity(ordemDto));
    }

    private OrdemDto convertToDto(Ordem ordem) {
        OrdemDto ordemDto = modelMapper.map(ordem, OrdemDto.class);
        ordemDto.setIdAtivo(ordem.getAtivo().getId());

        return ordemDto;
    }

    private Ordem convertToEntity(OrdemDto ordemDto) {
        Ordem ordem = modelMapper.map(ordemDto, Ordem.class);
        if (ordemDto.getIdAtivo() != null) {
            Ativo ativo = investimentoService.buscarAcaoPorId(ordemDto.getIdAtivo())
                    .orElseThrow(() -> new CarteiraAmigaException("Não foi possível converter a Ordem em seu DTO. O Ativo não foi encontrado."));
            ordem.setAtivo(ativo);
        }
        return ordem;
    }

}
