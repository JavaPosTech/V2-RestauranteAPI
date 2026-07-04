package br.com.fiap.restauranteapi.core.dto.UsuarioDTO;

public record UsuarioDTO(

        Integer id,

        String nome,

        String sobrenome,

        Integer tipoUsuarioId,

        Integer situacaoCadastroId,

        String situacaoCadastro,

        String dataCriacao

) {}
