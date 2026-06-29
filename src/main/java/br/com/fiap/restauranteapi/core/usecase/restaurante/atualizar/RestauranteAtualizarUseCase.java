package br.com.fiap.restauranteapi.core.usecase.restaurante.atualizar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RestauranteAtualizarUseCase {

    private final RestauranteGateway restauranteGateway;
    private final UsuarioGateway usuarioGateway;

    public MensagemSucessoResponse executar(Integer id, Restaurante restaurante) {
        Integer usuarioId = restaurante.getUsuario().getId();

        validarUsuarioExiste(usuarioId);

        Restaurante restauranteExistente = buscarOuLancarErro(id);

        validarDono(restauranteExistente, usuarioId);

        restauranteGateway.save(new Restaurante(
                id,
                restaurante.getUsuario(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento(),
                restauranteExistente.getDataCriacao()
        ), id);

        return new MensagemSucessoResponse(200, "Restaurante atualizado com sucesso!");
    }

    private void validarUsuarioExiste(Integer usuarioId) {
        if (!usuarioGateway.existsById(usuarioId)) {
            log.error("Usuário não encontrado! ID: {}", usuarioId);
            throw new RegistroNaoEncontradoException("Usuário não encontrado!");
        }
    }

    private Restaurante buscarOuLancarErro(Integer id) {
        return restauranteGateway.findById(id).orElseThrow(() -> {
            log.error("Restaurante não encontrado! ID: {}", id);
            return new RegistroNaoEncontradoException("Restaurante não encontrado!");
        });
    }

    private void validarDono(Restaurante restauranteExistente, Integer usuarioId) {
        if (!restauranteExistente.pertenceAoUsuario(usuarioId)) {
            log.error("Usuário {} tentou alterar o restaurante sem ser o dono!", usuarioId);
            throw new RegraDeNegocioException("Somente o dono do restaurante pode alterar ou remover o restaurante!");
        }
    }
}
