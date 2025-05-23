package com.vinicius.crudprodutos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vinicius.crudprodutos.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}