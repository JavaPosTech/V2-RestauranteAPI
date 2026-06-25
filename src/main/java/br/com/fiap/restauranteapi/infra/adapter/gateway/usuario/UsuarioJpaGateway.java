package br.com.fiap.restauranteapi.infra.adapter.gateway.usuario;

import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.usuario.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioJpaGateway implements UsuarioGateway {

    @Override
    public void salvar(UsuarioEntity usuarioEntity) {

    }
}