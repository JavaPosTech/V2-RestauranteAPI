package br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.BusinessException;
import br.com.fiap.restauranteapi.core.exceptions.ResourceNotFoundException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;

public class AtualizarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public AtualizarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public void executar(Integer id, TipoUsuario tipoUsuario) {
        if (tipoUsuarioGateway.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("O Tipo Usuário solicitado não foi encontrado!");
        }

        if (tipoUsuario.descricao() == null || tipoUsuario.descricao().isBlank()) {
            throw new BusinessException("A descrição do Tipo de Usuário é obrigatória!");
        }

        tipoUsuarioGateway.save(new TipoUsuario(id, tipoUsuario.descricao()));
    }
}