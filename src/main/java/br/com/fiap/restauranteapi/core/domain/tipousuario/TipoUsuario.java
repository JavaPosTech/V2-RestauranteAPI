package br.com.fiap.restauranteapi.core.domain.tipousuario;

import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;

public record TipoUsuario(

        Integer id,

        String descricao

) {

    public TipoUsuario {

        if (descricao == null || descricao.isBlank()) {
            throw new RegraDeNegocioException("A descrição do Tipo de Usuário é obrigatória!");
        }

        descricao = descricao.toUpperCase();
    }

    public static TipoUsuario criar(String descricao) {
        return new TipoUsuario(null, descricao);
    }
}