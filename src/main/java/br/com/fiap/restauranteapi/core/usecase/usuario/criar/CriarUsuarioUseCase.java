package br.com.fiap.restauranteapi.core.usecase.usuario.criar;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CriarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public MensagemSucessoResponse executar(Usuario usuario) {
        validarTipoUsuario(usuario.getTipoUsuarioId());

        usuarioGateway.save(usuario);

        return new MensagemSucessoResponse(
                201,
                "Usuário criado com sucesso!"
        );
    }

    private void validarTipoUsuario(Integer tipoUsuarioId) {
        if (tipoUsuarioId == null) {
            log.error("O Tipo de Usuário é obrigatório!");

            throw new RegraDeNegocioException(
                    "O Tipo de Usuário é obrigatório!"
            );
        }

        if (tipoUsuarioGateway.findById(tipoUsuarioId).isEmpty()) {
            log.error(
                    "O Tipo de Usuário informado não foi encontrado! ID: {}",
                    tipoUsuarioId
            );

            throw new RegistroNaoEncontradoException(
                    "O Tipo de Usuário informado não foi encontrado!"
            );
        }
    }
}