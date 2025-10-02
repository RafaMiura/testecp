package com.github.rafamiura.cp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.rafamiura.cp.model.Pedido;
import com.github.rafamiura.cp.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public List<Pedido> findByStatus(StatusPedido status);


}