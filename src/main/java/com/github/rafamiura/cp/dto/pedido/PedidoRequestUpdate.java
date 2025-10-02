package com.github.rafamiura.cp.dto.pedido;
import java.math.BigDecimal;
import com.github.rafamiura.cp.model.Pagamento;


public class PedidoRequestUpdate {
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pagamento toModel(Pagamento pagamentos) {
        pagamentos.setValor(this.valor);
        return pagamentos;
    }
}
