package br.com.fiap.restauranteapi.core.gateway.usuario;

import br.com.fiap.restauranteapi.infra.adapter.database.entity.usuario.UsuarioEntity;

public interface UsuarioGateway {

    void salvar(UsuarioEntity usuarioEntity);

}