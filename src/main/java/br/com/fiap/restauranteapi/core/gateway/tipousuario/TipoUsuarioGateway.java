package br.com.fiap.restauranteapi.core.gateway.tipousuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioGateway {

    List<TipoUsuario> findAll();

    Optional<TipoUsuario> findById(Integer id);

    boolean existsByDescricao(String descricao);

    boolean existsByDescricaoAndIdNot(String descricao, Integer id);

    void save(TipoUsuario tipoUsuario);

    void deleteById(Integer id);

}