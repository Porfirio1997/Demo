package com.example.Demo.repositories.daos.Produto.mapper;

import com.example.Demo.entities.Produto;
import com.example.Demo.repositories.daos.Produto.model.ProdutoModel;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Function;

public class ProdutoModelToProduto implements Function<ProdutoModel, Produto> {

    @Override
    public Produto apply(ProdutoModel produtoModel) {
        final var id = produtoModel.id();
        final var nome= produtoModel.nome();
        final var descricao= produtoModel.descricao();
        final var preco= produtoModel.preco();
        final var qtdestoque= produtoModel.qtdestoque();

        return  Produto.with(id,nome,descricao,preco,qtdestoque);
    }

    public static Produto convert(final ProdutoModel input) {
        return new ProdutoModelToProduto().apply(input);
    }

}
