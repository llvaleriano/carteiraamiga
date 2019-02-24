package br.com.vl.carteiraamiga.infra.repository;

import br.com.vl.carteiraamiga.domain.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtivoRepository extends JpaRepository<Acao, Long> {

    List<Acao> findBySiglaStartingWith(String sigla);
}
