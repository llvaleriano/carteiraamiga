package br.com.vl.carteiraamiga.application;

import br.com.vl.carteiraamiga.domain.Acao;
import br.com.vl.carteiraamiga.domain.Carteira;
import br.com.vl.carteiraamiga.domain.Ordem;
import br.com.vl.carteiraamiga.infra.repository.AtivoRepository;
import br.com.vl.carteiraamiga.infra.repository.CarteiraRepository;
import br.com.vl.carteiraamiga.infra.repository.OrdemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    private OrdemRepository ordemRepository;
    private AtivoRepository ativoRepository;
    private CarteiraRepository carteiraRepository;

    public InvestimentoService(AtivoRepository ativoRepository,
                               OrdemRepository ordemRepository,
                               CarteiraRepository carteiraRepository) {
        this.ativoRepository = ativoRepository;
        this.ordemRepository = ordemRepository;
        this.carteiraRepository = carteiraRepository;
    }

    public void salvarOrdem(Ordem ordem){
        ordemRepository.save(ordem);
    }

    public Optional<Acao> buscarAcaoPorId(Long id) {
        return ativoRepository.findById(id);
    }

    public List<Acao> listarAcoesPorSigla(String sigla) {
        return ativoRepository.findBySiglaStartingWith(sigla.toUpperCase());
    }

    public void salvarCarteira(Carteira carteira) {
        carteiraRepository.save(carteira);
    }
}
