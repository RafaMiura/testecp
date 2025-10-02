package com.github.rafamiura.cp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.rafamiura.cp.model.StatusPedido;
import com.github.rafamiura.cp.dto.pedido.PedidoRequestCreate; 
import com.github.rafamiura.cp.dto.pedido.PedidoResponse;
import com.github.rafamiura.cp.service.PedidoService;



@RestController
@RequestMapping("/api/${api.version}/pedidos")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequestCreate dto) {
        return ResponseEntity
                .status(201)
                .body(new PedidoResponse().toDto(pedidoService.create(dto))); 
    
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponse> findById(@PathVariable Long id){
        return pedidoService.findById(id)
            .map(pedido -> ResponseEntity.ok(new PedidoResponse().toDto(pedido)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<PedidoResponse>> listAll(){
	    return ResponseEntity.ok(pedidoService.findAll().stream()
            .map(pedido -> new PedidoResponse().toDto(pedido))
            .collect(Collectors.toList()));
    }

    // Query Parameter /pedidos/query?status=CANCELADO
    @GetMapping("query")
    public ResponseEntity<List<PedidoResponse>> findByValue(StatusPedido status){
	    return ResponseEntity.ok(pedidoService.findByStatus(status).stream()
            .map(pedido -> new PedidoResponse().toDto(pedido))
            .collect(Collectors.toList()));
    }
}
