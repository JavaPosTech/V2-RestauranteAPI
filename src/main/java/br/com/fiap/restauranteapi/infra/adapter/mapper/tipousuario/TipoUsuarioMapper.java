package br.com.fiap.restauranteapi.infra.adapter.mapper.tipousuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.tipousuario.TipoUsuarioEntity;
import br.com.fiap.restauranteapi.infra.controller.dto.tipousuario.TipoUsuarioRequest;

public class TipoUsuarioMapper {

    private TipoUsuarioMapper() {}

    public static TipoUsuario toDomain(TipoUsuarioRequest request) {
        return TipoUsuario.criar(request.descricao());
    }

    public static TipoUsuario toDomain(TipoUsuarioEntity entity) {
        return new TipoUsuario(entity.getId(), entity.getDescricao());
    }

    public static TipoUsuarioEntity toEntity(TipoUsuario domain) {
        TipoUsuarioEntity entity = new TipoUsuarioEntity();

        entity.setId(domain.getId());
        entity.setDescricao(domain.getDescricao());

        return entity;
    }
}