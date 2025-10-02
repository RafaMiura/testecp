package com.github.rafamiura.cp.model;


public enum StatusPedido {
    ABERTO("Pedido Aberto"), 
    CANCELADO("Pedido Cancelado"), 
    ENTREGUE("Pedido Entregue");

    private final String mensagem;

    StatusPedido(String mensagem) {  
        this.mensagem = mensagem;   
    }

    public String getMensagem() {
        return mensagem;
    }
}
