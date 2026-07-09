package br.com.fiap.restauranteapi.core.usecase.usuario.deletar;

import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public void executar(Integer id) {
        validarExistencia(id);

        usuarioGateway.deleteLogicoById(id);
    }

    private void validarExistencia(Integer id) {
        if (id == null) {
            log.error("O ID do Usuário é obrigatório para excluir!");
            throw new RegraDeNegocioException("O ID do Usuário é obrigatório!");
        }

        if (usuarioGateway.findById(id).isEmpty()) {
            log.error("O Usuário solicitado não foi encontrado! ID: {}", id);
            throw new RegistroNaoEncontradoException("O Usuário solicitado não foi encontrado!");
        }
    }
}