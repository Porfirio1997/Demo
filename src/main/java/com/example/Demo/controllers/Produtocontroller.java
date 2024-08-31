package com.example.Demo.controllers;

import com.example.Demo.controllers.dto.CreateProdutoDto;
import com.example.Demo.controllers.dto.UpdateProdutoDto;
import com.example.Demo.repositories.Produto.ProdutoRepository;
import com.example.Demo.repositories.daos.Produto.ProdutoDao;
import com.example.Demo.services.ProdutoService;
import com.example.Demo.services.dtos.inputs.ChangeProdutoServiceInputDto;
import com.example.Demo.services.dtos.inputs.CreateProdutoServiceInputDto;
import com.example.Demo.services.dtos.inputs.DeleteProdutoServiceInputDto;
import com.example.Demo.services.dtos.outputs.ChangeProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.CreateProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.ListProdutoServiceOutputDto;
import com.example.Demo.services.dtos.outputs.ProdutoServiceOutputDto;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class Produtocontroller {
    private ProdutoDao produtoDao = ProdutoDao.build();

    @GetMapping
    public ListProdutoServiceOutputDto getProdutos() {
        final var aRepository = ProdutoRepository.build(this.produtoDao);
        final var aService = ProdutoService.build(aRepository);
        return aService.getProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoServiceOutputDto getProduto(@PathVariable("id") final String id) {
        final var aRepository = ProdutoRepository.build(this.produtoDao);
        final var aService = ProdutoService.build(aRepository);
        return aService.getProduto(id);
    }

    @PostMapping("/{id}")
    public ChangeProdutoServiceOutputDto updateProduto(@PathVariable("id") final UUID id, @RequestBody final UpdateProdutoDto input) {
        final var aRepository = ProdutoRepository.build(this.produtoDao);
        final var aService = ProdutoService.build(aRepository);
        return aService.updateProduto(new ChangeProdutoServiceInputDto(id, input.nome(), input.descricao(), input.preco(), input.qtdestoque()));
    }

    @PostMapping
    public CreateProdutoServiceOutputDto createUser(@RequestBody final CreateProdutoDto input) {
        final var aRepository = ProdutoRepository.build(this.produtoDao);
        final var aService = ProdutoService.build(aRepository);
        return aService.createUser(new CreateProdutoServiceInputDto(input.nome(), input.descricao(), input.preco(), input.qtdestoque() , Instant.now().truncatedTo(ChronoUnit.MICROS)));
    }

    @DeleteMapping("/{id}")
    public DeleteProdutoServiceInputDto deleteProduto(@PathVariable("id") final UUID id) {
        final var aRepository = ProdutoRepository.build(this.produtoDao);
        final var aService = ProdutoService.build(aRepository);
        aService.deleteProduto(String.valueOf(id));
        return new DeleteProdutoServiceInputDto(id);
    }

}