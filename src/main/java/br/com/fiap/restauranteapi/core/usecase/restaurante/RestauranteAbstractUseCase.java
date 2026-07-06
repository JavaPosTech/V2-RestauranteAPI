package br.com.fiap.restauranteapi.core.usecase.restaurante;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import br.com.fiap.restauranteapi.core.enums.ETipoUsuario;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public abstract class RestauranteAbstractUseCase {

    protected final UsuarioGateway usuarioGateway;

    protected final RestauranteGateway restauranteGateway;

    protected void validarUsuarioExistencia(Integer usuarioId) {
        if (!usuarioGateway.existsById(usuarioId)) {
            log.error("Usuário não encontrado! ID: {}", usuarioId);
            throw new RegistroNaoEncontradoException("Usuário não encontrado!");
        }
    }

    protected Restaurante buscarRestaurantePorId(Integer id) {
        return restauranteGateway.findById(id).orElseThrow(() -> {
            log.error("Restaurante não encontrado! ID: {}", id);
            return new RegistroNaoEncontradoException("Restaurante não encontrado!");
        });
    }

    protected void validarDonoRestaurante(Restaurante restauranteExistente, Integer usuarioId) {
        if (restauranteExistente.pertenceAoUsuario(usuarioId)) {
            log.error("Usuário {} tentou alterar o Restaurante sem ser o Dono!", usuarioId);
            throw new RegraDeNegocioException("Somente o Dono do Restaurante pode alterar ou remover o Restaurante!");
        }
    }

    protected void validarUsuarioDonoRestaurante(Integer usuarioId) {
        var usuario = usuarioGateway.findById(usuarioId).orElseThrow(() -> {
            log.error("Usuário Dono de Restaurante não encontrado! ID: {}", usuarioId);
            return new RegistroNaoEncontradoException("Usuário Dono de Restaurante não encontrado");
        });

        if (!Objects.equals(usuario.getTipoUsuarioId(), ETipoUsuario.DONO_RESTAURANTE.getCodigo())) {
            log.error("O Usuário não é Dono de Restaurante! ID: {}", usuarioId);
            throw new RegraDeNegocioException("Somente usuários do tipo Dono de Restaurante podem cadastrar um restaurante!");
        }
    }
}