package com.vinicius.crudprodutos.exception;
import java.time.LocalDateTime;

public class ErroPadronizado {
    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String detalhes;

    public ErroPadronizado(LocalDateTime timestamp, int status, String erro, String detalhes) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.detalhes = detalhes;
    }  
}
