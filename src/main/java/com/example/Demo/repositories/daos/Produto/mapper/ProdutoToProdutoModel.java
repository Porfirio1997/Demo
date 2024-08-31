package com.example.Demo.repositories.daos.Produto.mapper;

import com.example.Demo.entities.Produto;
import com.example.Demo.repositories.daos.Produto.model.ProdutoModel;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

public class ProdutoToProdutoModel implements Function<Produto, ProdutoModel> {
    @Override
    public ProdutoModel apply(Produto input) {
        final var id = input.getId();
        final var nome= input.getNome();
        final var descricao= input.getDescricao();
        final var preco= input.getPreco();
        final var qtdestoque= input.getQtdestoque();

        return  ProdutoModel.with(id,nome,descricao,preco,qtdestoque, Instant.now().truncatedTo(ChronoUnit.MICROS));
    }

    public static ProdutoModel convert(final Produto input) {
        return new ProdutoToProdutoModel().apply(input);
    }
}
