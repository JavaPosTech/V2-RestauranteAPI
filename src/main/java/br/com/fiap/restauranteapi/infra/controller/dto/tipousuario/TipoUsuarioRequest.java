package br.com.fiap.restauranteapi.infra.controller.dto.tipousuario;

import jakarta.validation.constraints.NotBlank;

public record TipoUsuarioRequest(

        @NotBlank(message = "A descrição do tipo de usuário é obrigatória")
        String descricao

) {}