package br.com.fiap.restauranteapi.infra.adapter.database.repository.usuario;

import br.com.fiap.restauranteapi.infra.adapter.database.entity.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    List<UsuarioEntity> findAllBySituacaoCadastroId(Integer situacaoCadastroId);

    Optional<UsuarioEntity> findByIdAndSituacaoCadastroId(Integer id, Integer situacaoCadastroId);

}