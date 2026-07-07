package br.com.fiap.restauranteapi.core.dto.cardapio;

import java.math.BigDecimal;

public record CardapioDTO(

        Integer id,

        Integer restauranteId,

        String nome,

        String descricao,

        BigDecimal preco,

        Boolean consumoLocal,

        String foto

) {}