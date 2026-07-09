package br.com.fiap.restauranteapi.core.dto.usuario;

public record UsuarioDTO(

        Integer id,

        String nome,

        String sobrenome,

        Integer tipoUsuarioId,

        String situacaoCadastro,

        String dataCriacao

) {}