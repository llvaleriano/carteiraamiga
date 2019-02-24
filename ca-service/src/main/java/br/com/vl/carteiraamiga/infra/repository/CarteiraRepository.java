package br.com.vl.carteiraamiga.infra.repository;

import br.com.vl.carteiraamiga.domain.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
