package com.github.rafamiura.cp.dto.pagamento;
import java.math.BigDecimal;
import com.github.rafamiura.cp.model.Pagamento;


public class PagamentoRequestCreate {    
    private String descricao;
    private String metodoPagamento; 
    
    public Pagamento toModel() {
        BigDecimal VALOR_PADRAO = new BigDecimal(2000);        
        
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(VALOR_PADRAO);
        pagamento.setDescricao(this.descricao);
        pagamento.setMetodoPagamento(this.metodoPagamento);
        return pagamento;
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
}
