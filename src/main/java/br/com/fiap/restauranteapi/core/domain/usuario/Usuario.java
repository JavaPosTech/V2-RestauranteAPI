package br.com.fiap.restauranteapi.core.domain.usuario;

import java.time.LocalDateTime;

public record Usuario(

        Integer id,

        String nome,

        String descricao,

        Integer tipoUsuarioId,

        LocalDateTime dataCriacao

) {}