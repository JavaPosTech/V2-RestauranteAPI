package br.com.fiap.restauranteapi.core.usecase.tipousuario.listar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;

import java.util.List;

public class ListarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public ListarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public List<TipoUsuario> executar() {
        return tipoUsuarioGateway.findAll();
    }
}