package br.com.fatecsummit.rest_demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoInputDto {
    private String descricao;
    private BigDecimal valor;
}
