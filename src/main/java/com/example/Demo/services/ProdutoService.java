package com.example.Demo.services;

import com.example.Demo.entities.Produto;
import com.example.Demo.repositories.RepositoryInterface;
import com.example.Demo.services.dtos.inputs.ChangeProdutoServiceInputDto;
import com.example.Demo.services.dtos.inputs.CreateProdutoServiceInputDto;
import com.example.Demo.services.dtos.outputs.ChangeProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.CreateProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.ListProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.ProdutoServiceOutputDto;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProdutoService {

    private RepositoryInterface<Produto> produtoRepository;

    private ProdutoService(final RepositoryInterface<Produto> Repository) {
        this.produtoRepository = Repository;
    }

    public static ProdutoService build(final RepositoryInterface<Produto> Repository) {
        return new ProdutoService(Repository);
    }

    public CreateProdutoServiceOutputDto createUser(final CreateProdutoServiceInputDto input) {
        final var produto = Produto.build(input.nome(), input.descricao(), input.preco(), input.qtdestoque());
        this.produtoRepository.create(produto);
        return new CreateProdutoServiceOutputDto(produto.getId());
    }

    public ChangeProdutoServiceOutputDto updateProduto(final ChangeProdutoServiceInputDto input) {
        final var Produto = this.produtoRepository.getById(String.valueOf(input.id()));
        if (Produto == null) {
            throw new RuntimeException("Produto " + input.nome() + " not found");
        }
        Produto.changeNome(input.nome());
        Produto.setDescricao(input.descricao());
        Produto.setPreco(input.preco());
        Produto.setQtdestoque(input.qtdestoque());

        this.produtoRepository.update(Produto);

        return new ChangeProdutoServiceOutputDto(Produto.getId());
    }

    public ListProdutoServiceOutputDto getProdutos() {
        final var anProduto = this.produtoRepository.getAll();
        final var aReturn = anProduto.stream()
                .map(ProdutoServiceOutputDto::build)
                .collect(Collectors.toList());
        return new ListProdutoServiceOutputDto(aReturn);
    }

    public ProdutoServiceOutputDto getProduto(String id) {
        final var anProduto = this.produtoRepository.getById(id);
        return ProdutoServiceOutputDto.build(anProduto);
    }

    public void deleteProduto(String id) {
        this.produtoRepository.delete(id);
    }


}
