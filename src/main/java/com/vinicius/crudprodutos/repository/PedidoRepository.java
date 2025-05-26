package com.vinicius.crudprodutos.repository;
import com.vinicius.crudprodutos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findByPedidoExternoId(String pedidoExternoId);
}
