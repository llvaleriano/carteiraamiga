package br.com.vl.carteiraamiga.web;

import br.com.vl.carteiraamiga.application.InvestimentoService;
import br.com.vl.carteiraamiga.domain.Carteira;
import br.com.vl.carteiraamiga.web.dto.CarteiraDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carteira")
public class CarteiraResource {

    private InvestimentoService investimentoService;
    private ModelMapper modelMapper;

    public CarteiraResource(InvestimentoService investimentoService,
                            ModelMapper modelMapper) {
        this.investimentoService = investimentoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody void inserirCarteira(@RequestBody CarteiraDto carteiraDto) {
        Carteira carteira = convertToEntity(carteiraDto);
        investimentoService.salvarCarteira(carteira);
    }

    private Carteira convertToEntity(CarteiraDto carteiraDto) {
        return modelMapper.map(carteiraDto, Carteira.class);
    }
}
