package br.com.estudo.cache.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  nome;

    private BigDecimal valor;

    private LocalDateTime dataInclusao;

}
