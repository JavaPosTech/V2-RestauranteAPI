package br.com.fiap.restauranteapi.infra.adapter.database.repository.tipousuario;

import br.com.fiap.restauranteapi.infra.adapter.database.entity.tipousuario.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer> {

    boolean existsByDescricao(String descricao);

    boolean existsByDescricaoAndIdNot(String descricao, Integer id);

}