package br.com.fiap.restauranteapi.core.usecase.usuario.listar;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.dto.usuario.UsuarioDTO;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
public class ListarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public List<UsuarioDTO> executar() {
        return usuarioGateway.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTipoUsuarioId(),
                usuario.getSituacaoCadastro().getCodigo(),
                usuario.getSituacaoCadastro().getDescricao(),
                usuario.getDataCriacao() == null ? null : usuario.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );
    }
}