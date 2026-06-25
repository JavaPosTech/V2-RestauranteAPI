package br.com.fiap.restauranteapi.core.usecase.tipousuario.listar;

import br.com.fiap.restauranteapi.core.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public List<TipoUsuarioDTO> executar() {
        return tipoUsuarioGateway.findAll().stream()
                .map(tipoUsuario -> new TipoUsuarioDTO(tipoUsuario.getId(), tipoUsuario.getDescricao()))
                .toList();
    }
}