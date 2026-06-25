package br.com.fiap.restauranteapi.infra.adapter.gateway.tipousuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.tipousuario.TipoUsuarioRepository;
import br.com.fiap.restauranteapi.infra.adapter.mapper.TipoUsuarioMapper;
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
                .map(TipoUsuarioMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoUsuario> findById(Integer id) {
        return tipoUsuarioRepository.findById(id).map(TipoUsuarioMapper::toDomain);
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
        tipoUsuarioRepository.save(TipoUsuarioMapper.toEntity(tipoUsuario));
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}