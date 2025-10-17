package com.generation.lojagames.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.model.Produto;
import com.generation.lojagames.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getAllByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeJogoContainingIgnoreCase(nome));
    }
    
 // Buscar produtos com preço MAIOR que o valor informado
    @GetMapping("/maior/{preco}")
    public ResponseEntity<List<Produto>> getByPrecoMaior(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok(produtoRepository.findAllByPrecoGreaterThanOrderByPrecoAsc(preco));
    }
    
 // Buscar produtos com preço MENOR que o valor informado
    @GetMapping("/menor/{preco}")
    public ResponseEntity<List<Produto>> getByPrecoMenor(@PathVariable BigDecimal preco) {
        return ResponseEntity.ok(produtoRepository.findAllByPrecoLessThanOrderByPrecoDesc(preco));
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
        produto.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto) {
        if (produto.getId() == null || !produtoRepository.existsById(produto.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado para atualização");
        }
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        produtoRepository.deleteById(id);
    }
}
