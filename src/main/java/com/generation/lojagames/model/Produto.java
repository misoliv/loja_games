package com.generation.lojagames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank(message = "O atributo nome do jogo é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nome do jogo deve conter no mínimo 05 e no máximo 100 caracteres")
    private String nomeJogo;

    @Column(length = 1000)
    @NotBlank(message = "O atributo descricao é obrigatório!")
    @Size(min = 10, max = 1000, message = "O atributo descricao deve conter no mínimo 10 e no máximo 1000 caracteres")
    private String descricao;

    @Column(length = 100)
    @NotBlank(message = "O atributo marca é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo marca deve conter no mínimo 05 e no máximo 100 caracteres")
    private String marca;
    
    @NotNull(message = "O atributo preço é obrigatório!")
    @Positive(message = "O preço deve ser maior que zero!")
    private BigDecimal preco;

    @NotNull(message = "O atributo número de jogadores é obrigatório!")
    @Positive(message = "O número de jogadores deve ser maior que zero!") 
    private Integer numeroJogadores;
    
    @PositiveOrZero(message = "A avaliação não pode ser negativa!")
    private Double avaliacao;
    
    @Column
    @NotBlank(message = "O atributo foto é obrigatório!")
    private String foto;

    // RELACIONAMENTO COM CATEGORIA
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(Integer numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}


