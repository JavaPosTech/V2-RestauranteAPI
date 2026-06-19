package br.com.fiap.restauranteapi.core.gateway.usuario;

import br.com.fiap.restauranteapi.infra.adapter.entity.usuario.UsuarioEntity;

public interface UsuarioGateway {

    void salvar(UsuarioEntity usuarioEntity);

}