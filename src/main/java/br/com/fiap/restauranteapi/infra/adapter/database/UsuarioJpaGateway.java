package br.com.fiap.restauranteapi.infra.adapter.database;

import br.com.fiap.restauranteapi.core.gateway.UsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.entity.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioJpaGateway implements UsuarioGateway {

    @Override
    public void salvar(Usuario usuario) {

    }
}