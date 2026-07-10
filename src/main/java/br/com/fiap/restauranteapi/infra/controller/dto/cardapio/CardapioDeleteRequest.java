package br.com.fiap.restauranteapi.infra.controller.dto.cardapio;

import jakarta.validation.constraints.NotNull;

public record CardapioDeleteRequest(

        @NotNull(message = "O ID do usuário é obrigatório!")
        Integer usuarioId

) {}