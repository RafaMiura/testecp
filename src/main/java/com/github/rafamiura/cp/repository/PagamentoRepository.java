package com.github.rafamiura.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.rafamiura.cp.model.Pagamento;

@Repository
public interface PagamentoRepository 
        extends JpaRepository<Pagamento, Long> {
}
