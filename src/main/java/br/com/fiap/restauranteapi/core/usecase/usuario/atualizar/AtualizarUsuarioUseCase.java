package br.com.fiap.restauranteapi.core.usecase.usuario.atualizar;

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
public class AtualizarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public MensagemSucessoResponse executar(Integer id, Usuario usuario) {
        validarId(id);

        var usuarioAtual = usuarioGateway.findById(id).orElseThrow(() -> {
            log.error("O Usuário solicitado não foi encontrado! ID: {}", id);
            return new RegistroNaoEncontradoException("O Usuário solicitado não foi encontrado!");
        });

        if (usuario.getTipoUsuarioId() != null) {
            validarTipoUsuarioExistente(usuario.getTipoUsuarioId());
        }

        var usuarioAtualizado = new Usuario(
                id,
                usuario.getNome() == null ? usuarioAtual.getNome() : usuario.getNome(),
                usuario.getSobrenome() == null ? usuarioAtual.getSobrenome() : usuario.getSobrenome(),
                usuario.getTipoUsuarioId() == null ? usuarioAtual.getTipoUsuarioId() : usuario.getTipoUsuarioId(),
                usuarioAtual.getDataCriacao(),
                usuarioAtual.getSituacaoCadastro()
        );

        usuarioGateway.save(usuarioAtualizado);
        return new MensagemSucessoResponse(200, "Usuário atualizado com sucesso!");
    }

    private void validarId(Integer id) {
        if (id == null) {
            log.error("O ID do Usuário é obrigatório para atualizar!");
            throw new RegraDeNegocioException("O ID do Usuário é obrigatório!");
        }
    }

    private void validarTipoUsuarioExistente(Integer tipoUsuarioId) {
        if (tipoUsuarioGateway.findById(tipoUsuarioId).isEmpty()) {
            log.error("O Tipo de Usuário informado não foi encontrado! ID: {}", tipoUsuarioId);
            throw new RegistroNaoEncontradoException("O Tipo de Usuário informado não foi encontrado!");
        }
    }
}