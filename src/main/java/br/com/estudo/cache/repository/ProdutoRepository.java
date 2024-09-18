package br.com.estudo.cache.repository;

import br.com.estudo.cache.domain.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
