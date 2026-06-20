package br.com.fiap.restauranteapi.core.domain.tipousuario;

import br.com.fiap.restauranteapi.core.exceptions.BusinessException;

public record TipoUsuario(

        Integer id,

        String descricao

) {
    public static TipoUsuario toDomain(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new BusinessException("A descrição do Tipo de Usuário é obrigatória!");
        }

        return new TipoUsuario(null, descricao.toUpperCase());
    }
}