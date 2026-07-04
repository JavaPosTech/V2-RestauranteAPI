package br.com.fiap.restauranteapi.infra.controller.dto.usuario;

import jakarta.validation.constraints.Min;

public record AtualizarUsuarioRequest(

        String nome,

        String sobrenome,

        @Min(value = 1, message = "O Tipo de Usuário deve 1")
        Integer tipoUsuarioId

) {}
