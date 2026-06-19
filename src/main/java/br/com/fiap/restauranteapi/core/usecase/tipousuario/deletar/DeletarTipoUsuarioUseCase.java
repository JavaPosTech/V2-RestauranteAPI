package br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar;

import br.com.fiap.restauranteapi.core.exceptions.BusinessException;
import br.com.fiap.restauranteapi.core.exceptions.ResourceNotFoundException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;

public class DeletarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public DeletarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public void executar(Integer id) {
        if (id == null) {
            throw new BusinessException("O ID do Tipo de Usuário é obrigatório!");
        }

        if (tipoUsuarioGateway.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("O Tipo de Usuário solicitado não foi encontrado!");
        }

        tipoUsuarioGateway.deleteById(id);
    }
}