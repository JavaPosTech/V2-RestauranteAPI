package br.com.fiap.restauranteapi.infra.controller.dto.restaurante;

import jakarta.validation.constraints.NotNull;

public record RestauranteDeleteRequest(

        @NotNull(message = "O ID do usuário é obrigatório")
        Integer usuarioId

) {}
