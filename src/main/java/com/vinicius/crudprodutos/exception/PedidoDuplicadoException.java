package com.vinicius.crudprodutos.exception;

public class PedidoDuplicadoException extends RuntimeException {
    public PedidoDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
