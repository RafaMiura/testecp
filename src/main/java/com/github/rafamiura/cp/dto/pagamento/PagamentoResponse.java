package com.github.rafamiura.cp.dto.pagamento;
import java.math.BigDecimal;
import com.github.rafamiura.cp.model.Pagamento;



public class PagamentoResponse {
    private Long id;
    private String descricao;
    private String metodoPagamento;
    private BigDecimal valor;

    public PagamentoResponse toDto(Pagamento pagamento) {
        this.setId(pagamento.getId());
        this.setDescricao(pagamento.getDescricao());
        this.setMetodoPagamento(pagamento.getMetodoPagamento());
        this.setValor(pagamento.getValor());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
   