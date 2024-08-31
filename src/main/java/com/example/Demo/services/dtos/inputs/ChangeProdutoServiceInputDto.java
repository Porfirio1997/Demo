package com.example.Demo.services.dtos.inputs;

import java.math.BigDecimal;
import java.util.UUID;

public record ChangeProdutoServiceInputDto(UUID id, String nome, String descricao, BigDecimal preco, Integer qtdestoque) {
}
