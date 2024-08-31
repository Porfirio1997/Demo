package com.example.Demo.controllers.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateProdutoDto(UUID id , String nome, String descricao, BigDecimal preco, Integer qtdestoque) {
}
