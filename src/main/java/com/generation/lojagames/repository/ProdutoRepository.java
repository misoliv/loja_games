package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeJogoContainingIgnoreCase(String nomeJogo); 
	
	// Produtos com preço MAIOR que o valor informado (ordem crescente)
    public List<Produto> findAllByPrecoGreaterThanOrderByPrecoAsc(BigDecimal preco);

    // Produtos com preço MENOR que o valor informado (ordem decrescente)
    public List<Produto> findAllByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
}


