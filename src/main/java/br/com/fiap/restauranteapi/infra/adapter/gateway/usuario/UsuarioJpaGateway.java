package br.com.fiap.restauranteapi.infra.adapter.gateway.usuario;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.infra.adapter.database.repository.usuario.UsuarioRepository;
import br.com.fiap.restauranteapi.infra.adapter.mapper.usuario.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioJpaGateway implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAllBySituacaoCadastroId(ESituacaoCadastro.ATIVO.getCodigo()).stream()
                .map(UsuarioMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findByIdAndSituacaoCadastroId(id, ESituacaoCadastro.ATIVO.getCodigo())
                .map(UsuarioMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Integer id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioRepository.save(UsuarioMapper.toEntity(usuario));
    }

    @Override
    @Transactional
    public void deleteLogicoById(Integer id) {
        var usuarioEntity = usuarioRepository.findByIdAndSituacaoCadastroId(id, ESituacaoCadastro.ATIVO.getCodigo())
                .orElseThrow();

        usuarioEntity.setSituacaoCadastroId(ESituacaoCadastro.EXCLUIDO.getCodigo());

        usuarioRepository.save(usuarioEntity);
    }
}