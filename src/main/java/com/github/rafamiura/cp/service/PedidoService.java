package com.github.rafamiura.cp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.rafamiura.cp.model.Pedido;
import com.github.rafamiura.cp.model.StatusPedido;
import com.github.rafamiura.cp.repository.PedidoRepository;
import com.github.rafamiura.cp.dto.pedido.PedidoRequestCreate;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Método de criação do pedido ajustado
    public Pedido create(PedidoRequestCreate dto) {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.ABERTO); // Status inicial do pedido
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setDataEntrega(dto.getDataEntrega());

        // Como você não está mais utilizando "items", o pedido será salvo sem eles
        return pedidoRepository.save(pedido);
    }

    // Buscar pedido por ID
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    // Buscar todos os pedidos
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    // Buscar pedidos por status
    public List<Pedido> findByStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }
}
