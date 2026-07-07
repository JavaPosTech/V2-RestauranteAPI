package br.com.fiap.restauranteapi.infra.controller.dto.restaurante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestauranteRequest(

        @NotNull(message = "O ID do usuário é obrigatório!")
        Integer usuarioId,

        @NotBlank(message = "O nome do restaurante é obrigatório!")
        String nome,

        @NotBlank(message = "O endereço do restaurante é obrigatório!")
        String endereco,

        @NotBlank(message = "O tipo de cozinha é obrigatório!")
        String tipoCozinha,

        @NotBlank(message = "A hora de abertura é obrigatória!")
        String horaAbertura,

        @NotBlank(message = "A hora de fechamento é obrigatória!")
        String horaFechamento

) {}
