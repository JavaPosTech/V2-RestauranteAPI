package br.com.fiap.restauranteapi.infra.adapter.database.tipousuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.entity.tipousuario.TipoUsuarioEntity;
import br.com.fiap.restauranteapi.infra.adapter.repository.tipousuario.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TipoUsuarioJpaGateway implements TipoUsuarioGateway {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll().stream()
                .map(TipoUsuarioEntity::toDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUsuario> findById(Integer id) {
        return tipoUsuarioRepository.findById(id).map(TipoUsuarioEntity::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByDescricao(String descricao) {
        return tipoUsuarioRepository.existsByDescricao(descricao);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByDescricaoAndIdNot(String descricao, Integer id) {
        return tipoUsuarioRepository.existsByDescricaoAndIdNot(descricao, id);
    }

    @Override
    @Transactional
    public void save(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(TipoUsuarioEntity.fromDomain(tipoUsuario));
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}