package br.com.fiap.restauranteapi.core.domain.cardapio;

import java.math.BigDecimal;

public record Cardapio(

        Integer id,

        Integer restauranteId,

        String nome,

        String descricao,

        BigDecimal preco,

        boolean consumoLocal,

        String foto

) {}