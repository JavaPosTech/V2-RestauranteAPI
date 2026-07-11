package br.com.fiap.restauranteapi.infra.adapter.mapper.usuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.tipousuario.TipoUsuarioEntity;
import br.com.fiap.restauranteapi.infra.adapter.database.entity.usuario.UsuarioEntity;
import br.com.fiap.restauranteapi.infra.controller.dto.usuario.AtualizarUsuarioRequest;
import br.com.fiap.restauranteapi.infra.controller.dto.usuario.UsuarioRequest;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static Usuario toDomain(UsuarioRequest request) {
        return Usuario.criar(request.nome(), request.sobrenome(), new TipoUsuario(request.tipoUsuarioId()));
    }

    public static Usuario toDomain(AtualizarUsuarioRequest request) {
        return Usuario.atualizar(request.nome(), request.sobrenome(), new TipoUsuario(request.tipoUsuarioId()));
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNome(),
                entity.getSobrenome(),
                new TipoUsuario(entity.getTipoUsuario().getId(), entity.getTipoUsuario().getDescricao()),
                entity.getDataCriacao(),
                ESituacaoCadastro.fromCodigo(entity.getSituacaoCadastroId())
        );
    }

    public static UsuarioEntity toEntity(Usuario domain) {
        UsuarioEntity entity = new UsuarioEntity();

        entity.setId(domain.getId());
        entity.setNome(domain.getNome().toUpperCase());
        entity.setSobrenome(domain.getSobrenome().toUpperCase());
        entity.setTipoUsuario(new TipoUsuarioEntity(domain.getTipoUsuario().getId(), domain.getTipoUsuario().getDescricao()));
        entity.setSituacaoCadastroId(domain.getId() == null ? ESituacaoCadastro.ATIVO.getCodigo() : domain.getSituacaoCadastro().getCodigo());

        return entity;
    }
}