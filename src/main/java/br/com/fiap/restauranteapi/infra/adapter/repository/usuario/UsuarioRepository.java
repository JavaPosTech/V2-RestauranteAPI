package br.com.fiap.restauranteapi.infra.adapter.repository.usuario;

import br.com.fiap.restauranteapi.infra.adapter.entity.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}