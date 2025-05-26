package com.vinicius.crudprodutos.service;
import com.vinicius.crudprodutos.dto.PedidoRequest;
import com.vinicius.crudprodutos.dto.PedidoItemRequest;
import com.vinicius.crudprodutos.exception.PedidoDuplicadoException;
import com.vinicius.crudprodutos.model.ItemPedido;
import com.vinicius.crudprodutos.model.Pedido;
import com.vinicius.crudprodutos.model.Produto;
import com.vinicius.crudprodutos.repository.PedidoRepository;
import com.vinicius.crudprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    public Pedido processarPedido(PedidoRequest pedidoRequest) {
        String pedidoExternoId = pedidoRequest.getPedidoExternoId();
        if (pedidoRepository.findByPedidoExternoId(pedidoExternoId).isPresent()) {
            throw new PedidoDuplicadoException("Pedido com ID externo " + pedidoExternoId + " já foi processado.");
        }
        Pedido pedido = new Pedido();
        pedido.setPedidoExternoId(pedidoExternoId);
        pedido.setStatus("PROCESSANDO");
        List<ItemPedido> itensPedido = new ArrayList<>();
        double valorTotal = 0.0;
        for (PedidoItemRequest itemRequest : pedidoRequest.getItens()) {
            Produto produto = produtoRepository.findById(itemRequest.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + itemRequest.getProdutoId()));
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProdutoId(produto.getId());
            itemPedido.setQuantidade(itemRequest.getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPreco());
            itemPedido.setPedido(pedido);
            itensPedido.add(itemPedido);
            valorTotal += produto.getPreco() * itemRequest.getQuantidade();
        }
        pedido.setItens(itensPedido);
        pedido.setValorTotal(valorTotal);
        pedido.setStatus("PROCESSADO");
        return pedidoRepository.save(pedido);
    }
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
