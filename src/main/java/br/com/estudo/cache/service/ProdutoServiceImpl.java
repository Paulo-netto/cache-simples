package br.com.estudo.cache.service;

import br.com.estudo.cache.domain.ProdutoModel;
import br.com.estudo.cache.domain.record.Produto;
import br.com.estudo.cache.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{


    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoModel getProdutoById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto com id " + id + " não encontrado."));
    }

    @Override
    public ProdutoModel salvarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    @Override
    public ProdutoModel updateProduto(Long id, Produto produtoRecord) {
        var produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto com id " + id + " não encontrado."));
        BeanUtils.copyProperties(produtoRecord, produto);
        produto.setDataInclusao(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

}
