package com.github.rafamiura.cp.dto.pagamento;
import java.math.BigDecimal;
import com.github.rafamiura.cp.model.Pagamento;

public class PagamentoRequestUpdate {
    private BigDecimal valor;
    private String descricao;
    private String metodoPagamento; // Novo campo, caso queira atualizar o método de pagamento

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public Pagamento toModel(Pagamento pagamento) {
        pagamento.setValor(this.valor);
        pagamento.setDescricao(this.descricao);
        pagamento.setMetodoPagamento(this.metodoPagamento);
        return pagamento;
    }
}

