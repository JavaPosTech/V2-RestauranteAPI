package br.com.fiap.restauranteapi.core.gateway;

import br.com.fiap.restauranteapi.infra.adapter.entity.usuario.Usuario;

public interface UsuarioGateway {

    void salvar(Usuario usuario);

}