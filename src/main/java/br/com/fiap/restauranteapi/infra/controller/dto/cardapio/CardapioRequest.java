package br.com.fiap.restauranteapi.infra.controller.dto.cardapio;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CardapioRequest(

        @NotNull(message = "O ID do restaurante é obrigatório")
        Integer restauranteId,

        @NotNull(message = "O ID do usuário é obrigatório")
        Integer usuarioId,

        @NotBlank(message = "O nome do item do cardápio é obrigatório")
        String nome,

        @NotBlank(message = "A descrição do item do cardápio é obrigatória")
        String descricao,

        @NotNull(message = "O preço do item do cardápio é obrigatório")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @NotNull(message = "Informe se o item é para consumo local")
        Boolean consumoLocal,

        String foto

) {}