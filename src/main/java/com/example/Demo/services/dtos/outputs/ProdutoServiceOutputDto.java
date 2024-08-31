package com.example.Demo.services.dtos.outputs;

import com.example.Demo.entities.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoServiceOutputDto(UUID id , String nome, String descricao, BigDecimal preco, Integer qtdestoque){

    public static ProdutoServiceOutputDto build(final Produto produto) {
        return new ProdutoServiceOutputDto( produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQtdestoque());
    }
}
