package br.com.fiap.restauranteapi.core.usecase.usuario.criar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
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
        validarTipoUsuario(usuario.getTipoUsuario());

        usuarioGateway.save(usuario);

        return new MensagemSucessoResponse(201, "Usuário criado com sucesso!");
    }

    private void validarTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuarioGateway.findById(tipoUsuario.getId()).isEmpty()) {
            log.error("O Tipo de Usuário informado não foi encontrado! ID: {}", tipoUsuario.getId());
            throw new RegistroNaoEncontradoException("O Tipo de Usuário informado não foi encontrado!");
        }
    }
}