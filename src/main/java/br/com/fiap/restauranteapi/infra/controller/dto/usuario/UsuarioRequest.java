package br.com.fiap.restauranteapi.infra.controller.dto.usuario;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O sobrenome do usuário é obrigatório!")
        String sobrenome,

        @NotNull(message = "O Tipo de Usuário é obrigatório!")
        @Min(value = 1, message = "O Tipo de Usuário deve ser um número positivo!")
        Integer tipoUsuarioId

) {}