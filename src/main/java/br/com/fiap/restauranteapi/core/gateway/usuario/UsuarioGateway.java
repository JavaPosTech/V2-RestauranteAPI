package br.com.fiap.restauranteapi.core.gateway.usuario;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    boolean existsById(Integer id);

    void save(Usuario usuario);

    void deleteLogicoById(Integer id);

}