package com.example.Demo.repositories.daos.Produto.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public record ProdutoModel( UUID id, String nome , String descricao, BigDecimal preco,  Integer qtdestoque,Instant createdAt) {

    public static ProdutoModel build(UUID id, String nome, String descricao, BigDecimal preco,  Integer qtdestoque) {
        return new ProdutoModel(id, nome, descricao, preco, qtdestoque, Instant.now().truncatedTo(ChronoUnit.MICROS));
    }

    public static ProdutoModel with( UUID id,String nome, String descricao, BigDecimal preco, Integer qtdestoque,Instant createdAt){
        return new ProdutoModel(id,nome, descricao, preco, qtdestoque, createdAt);
    }

}
