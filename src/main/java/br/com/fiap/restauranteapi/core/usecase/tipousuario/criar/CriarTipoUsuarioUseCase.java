package br.com.fiap.restauranteapi.core.usecase.tipousuario.criar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.BusinessException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;

public class CriarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public CriarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public void executar(TipoUsuario tipoUsuario) {
        if (tipoUsuarioGateway.existsByDescricao(tipoUsuario.descricao())) {
            throw new BusinessException("Tipo de Usuário já cadastrado com essa descrição!");
        }

        tipoUsuarioGateway.save(tipoUsuario);
    }
}
