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

    private final UsuarioGateway usuarioGateway;

    private final RestauranteGateway restauranteGateway;

    public MensagemSucessoResponse executar(Integer id, Restaurante restaurante) {
        Integer usuarioId = restaurante.getUsuario().getId();

        validarUsuarioExistencia(usuarioId);

        Restaurante restauranteExistente = buscarRestaurantePorId(id);

        validarDonoRestaurante(restauranteExistente, usuarioId);

        restauranteGateway.save(new Restaurante(
                id,
                restaurante.getUsuario(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHoraAbertura(),
                restaurante.getHoraFechamento(),
                restauranteExistente.getDataCriacao()));

        return new MensagemSucessoResponse(200, "Restaurante atualizado com sucesso!");
    }

    private void validarUsuarioExistencia(Integer usuarioId) {
        if (usuarioGateway.existsById(usuarioId)) {
            log.error("Usuário não encontrado! ID: {}", usuarioId);
            throw new RegistroNaoEncontradoException("Usuário não encontrado!");
        }
    }

    private Restaurante buscarRestaurantePorId(Integer id) {
        return restauranteGateway.findById(id).orElseThrow(() -> {
            log.error("Restaurante não encontrado! ID: {}", id);
            return new RegistroNaoEncontradoException("Restaurante não encontrado!");
        });
    }

    private void validarDonoRestaurante(Restaurante restauranteExistente, Integer usuarioId) {
        if (restauranteExistente.pertenceAoUsuario(usuarioId)) {
            log.error("Usuário {} tentou alterar o Restaurante sem ser o Dono!", usuarioId);
            throw new RegraDeNegocioException("Somente o Dono do Restaurante pode alterar ou remover o Restaurante!");
        }
    }
}