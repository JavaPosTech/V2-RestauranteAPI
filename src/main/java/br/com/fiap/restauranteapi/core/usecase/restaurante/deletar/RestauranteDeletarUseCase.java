package br.com.fiap.restauranteapi.core.usecase.restaurante.deletar;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RestauranteDeletarUseCase {

    private final RestauranteGateway restauranteGateway;
    private final UsuarioGateway usuarioGateway;

    public void executar(Integer id, Integer usuarioId) {
        validarUsuarioExiste(usuarioId);

        Restaurante restaurante = buscarOuLancarErro(id);

        validarDono(restaurante, usuarioId);

        restauranteGateway.deleteById(id);
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

    private void validarDono(Restaurante restaurante, Integer usuarioId) {
        if (!restaurante.pertenceAoUsuario(usuarioId)) {
            log.error("Usuário {} tentou remover o restaurante sem ser o dono!", usuarioId);
            throw new RegraDeNegocioException("Somente o dono do restaurante pode alterar ou remover o restaurante!");
        }
    }
}
