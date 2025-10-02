package com.github.rafamiura.cp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.rafamiura.cp.dto.pagamento.PagamentoRequestCreate;
import com.github.rafamiura.cp.dto.pagamento.PagamentoRequestUpdate;
import com.github.rafamiura.cp.dto.pagamento.PagamentoResponse;
import com.github.rafamiura.cp.service.PagamentoService;

@RestController
@RequestMapping("/api/${api.version}/pagamentos")
public class ControllerPagamento {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoResponse> create(@RequestBody PagamentoRequestCreate dto) {
        return ResponseEntity.status(201).body(
                new PagamentoResponse().toDto(pagamentoService.createPagamento(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = pagamentoService.deletePagamento(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponse> update(@PathVariable Long id, @RequestBody PagamentoRequestUpdate dto) {
        return pagamentoService.updatePagamento(id, dto)
                .map(p -> new PagamentoResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> findById(@PathVariable Long id) {
        return pagamentoService.getPagamentoById(id)
                .map(p -> new PagamentoResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponse>> findAll() {
        List<PagamentoResponse> response = pagamentoService.getAll().stream()
                .map(p -> new PagamentoResponse().toDto(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
