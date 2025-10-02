package com.github.rafamiura.cp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.rafamiura.cp.model.Pagamento;
import com.github.rafamiura.cp.repository.PagamentoRepository;
import com.github.rafamiura.cp.dto.pagamento.PagamentoRequestUpdate;
import com.github.rafamiura.cp.dto.pagamento.PagamentoRequestCreate;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento createPagamento(PagamentoRequestCreate dto) {
        return pagamentoRepository.save(dto.toModel());
    }

    public Optional<Pagamento> updatePagamento(Long id, PagamentoRequestUpdate dto) {
        return pagamentoRepository.findById(id)
            .map(p -> pagamentoRepository.save(dto.toModel(p)));
    }

    public Optional<Pagamento> getPagamentoById(Long id) {
        return pagamentoRepository.findById(id);
    }

    public List<Pagamento> getAll() {
        return pagamentoRepository.findAll();
    }

    public boolean deletePagamento(Long id) {
        if (pagamentoRepository.existsById(id)) {
            pagamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}