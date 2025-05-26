package com.vinicius.crudprodutos.repository;
import com.vinicius.crudprodutos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
