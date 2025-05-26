package com.vinicius.crudprodutos.controller;

import com.vinicius.crudprodutos.dto.PedidoRequest;
import com.vinicius.crudprodutos.model.Pedido;
import com.vinicius.crudprodutos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        return pedidoService.processarPedido(pedidoRequest);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }    
}
