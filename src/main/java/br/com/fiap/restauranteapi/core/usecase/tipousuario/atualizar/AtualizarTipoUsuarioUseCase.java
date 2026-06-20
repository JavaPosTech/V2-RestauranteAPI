package br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.BusinessException;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;

public class AtualizarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public AtualizarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public void executar(Integer id, TipoUsuario tipoUsuario) {
        if (tipoUsuarioGateway.findById(id).isEmpty()) {
            throw new RegistroNaoEncontradoException("O Tipo Usuário solicitado não foi encontrado!");
        }

        if (tipoUsuarioGateway.existsByDescricaoAndIdNot(tipoUsuario.descricao(), id)) {
            throw new BusinessException("Já existe um Tipo de Usuário com a descrição informada!");
        }

        tipoUsuarioGateway.save(new TipoUsuario(id, tipoUsuario.descricao()));
    }
}