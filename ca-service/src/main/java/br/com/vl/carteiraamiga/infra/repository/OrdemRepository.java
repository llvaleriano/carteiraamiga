package br.com.vl.carteiraamiga.infra.repository;

import br.com.vl.carteiraamiga.domain.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Integer> {

}
