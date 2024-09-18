package br.com.estudo.cache.service;

import br.com.estudo.cache.domain.ProdutoModel;
import br.com.estudo.cache.domain.record.Produto;

public interface ProdutoService {

    ProdutoModel getProdutoById(Long id);

    ProdutoModel salvarProduto(ProdutoModel produtoModel);

    ProdutoModel updateProduto(Long id, Produto produtoRecord);
}
