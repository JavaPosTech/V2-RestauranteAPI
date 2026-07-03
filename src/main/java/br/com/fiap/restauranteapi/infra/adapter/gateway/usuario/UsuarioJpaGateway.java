package br.com.fiap.restauranteapi.infra.adapter.gateway.usuario;

import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UsuarioJpaGateway implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return !usuarioRepository.existsById(id);
    }
}