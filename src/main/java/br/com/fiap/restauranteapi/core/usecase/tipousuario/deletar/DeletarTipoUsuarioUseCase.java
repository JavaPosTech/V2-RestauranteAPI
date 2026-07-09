package br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar;

import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeletarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public void executar(Integer id) {
        validarExistencia(id);
        tipoUsuarioGateway.deleteById(id);
    }

    private void validarExistencia(Integer id) {
        if (id == null) {
            log.error("O ID do Tipo de Usuário é obrigatório para excluir!");
            throw new RegraDeNegocioException("O ID do Tipo de Usuário é obrigatório!");
        }

        if (tipoUsuarioGateway.findById(id).isEmpty()) {
            log.error("O Tipo de Usuário solicitado não foi encontrado!");
            throw new RegistroNaoEncontradoException("O Tipo de Usuário solicitado não foi encontrado!");
        }
    }
}