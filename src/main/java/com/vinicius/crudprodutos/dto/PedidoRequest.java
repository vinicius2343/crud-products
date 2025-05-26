package com.vinicius.crudprodutos.dto;
import java.util.List;

public class PedidoRequest {
    private String pedidoExternoId;
    private List<PedidoItemRequest> itens;
    public String getPedidoExternoId() {
        return pedidoExternoId;
    }
    public void setPedidoExternoId(String pedidoExternoId) {
        this.pedidoExternoId = pedidoExternoId;
    }
    public List<PedidoItemRequest> getItens() {
        return itens;
    }
    public void setItens(List<PedidoItemRequest> itens) {
        this.itens = itens;
    }
}
