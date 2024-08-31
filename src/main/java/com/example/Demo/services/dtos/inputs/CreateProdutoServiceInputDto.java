package com.example.Demo.services.dtos.inputs;

import java.math.BigDecimal;
import java.time.Instant;

public record CreateProdutoServiceInputDto(String nome, String descricao, BigDecimal preco, Integer qtdestoque,Instant createdAt) {
}
