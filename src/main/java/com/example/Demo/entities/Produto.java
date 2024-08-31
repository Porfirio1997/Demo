package com.example.Demo.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

//nome, descrição, preço e quantidade em estoque
public class Produto {
    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer qtdestoque;
    private Instant createdAt;

    private Produto(String nome,String descricao,BigDecimal preco,Integer qtdestoque){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdestoque = qtdestoque;
        this.createdAt = Instant.now().truncatedTo(ChronoUnit.MICROS);
    }

    private Produto(UUID id,String nome,String descricao,BigDecimal preco,Integer qtdestoque){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdestoque = qtdestoque;
    }


    public static Produto build(String nome, String descricao, BigDecimal preco, Integer qtdestoque) {
        return new Produto(nome, descricao, preco, qtdestoque);
    }
    public static Produto with(String nome,String descricao,BigDecimal preco,Integer qtdestoque) {
        return new Produto(nome, descricao,preco,qtdestoque);
    }
    public static Produto with( UUID id ,String nome,String descricao,BigDecimal preco,Integer qtdestoque) {
        return new Produto(id, nome, descricao,preco,qtdestoque);
    }

    public void changeNome(final String newName) {
        if (newName.isBlank()) {
            throw new RuntimeException("Nome do Produto deve ser preenchido");
        }

        if (newName.length() < 5) {
            throw new RuntimeException("Nome do Produto deve ter pelo menos 5 letras");
        }

        this.nome = newName;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public void setQtdestoque(Integer qtdestoque) {
        this.qtdestoque = qtdestoque;
    }

    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public Integer getQtdestoque() {
        return qtdestoque;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", qtdestoque=" + qtdestoque + ", createdAt=" + createdAt + "]";
    }


}
