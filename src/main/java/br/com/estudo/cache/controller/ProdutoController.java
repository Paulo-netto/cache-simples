package br.com.estudo.cache.controller;

import br.com.estudo.cache.domain.ProdutoModel;
import br.com.estudo.cache.domain.record.Produto;
import br.com.estudo.cache.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/salvar")
    @CacheEvict(value = "produto", allEntries = true)
    public ResponseEntity<?> salvarProduto(@RequestBody Produto produtoRecord) {
        var produto = new ProdutoModel();
        BeanUtils.copyProperties(produtoRecord, produto);
        produto.setDataInclusao(LocalDateTime.now());
        produtoService.salvarProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "produto")
    public ResponseEntity<?> buscarProduto(@PathVariable("id") Long id) {
        var resultado = produtoService.getProdutoById(id);
        resultado.setDataInclusao(LocalDateTime.now());
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Cacheable(value = "produto")
    public ResponseEntity<?> updateProduto(@PathVariable("id") Long id, @Valid @RequestBody Produto produtoRecord) {
        produtoService.updateProduto(id, produtoRecord);
        return new ResponseEntity<>(produtoRecord, HttpStatus.OK);
    }

}
