package br.com.fiap.restauranteapi.core.usecase.tipousuario.criar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CriarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public MensagemSucessoResponse executar(TipoUsuario tipoUsuario) {
        validarDescricaoUnica(tipoUsuario);

        tipoUsuarioGateway.save(tipoUsuario);

        return new MensagemSucessoResponse(201, "Tipo de Usuário criado com sucesso!");
    }

    private void validarDescricaoUnica(TipoUsuario tipoUsuario) {
        if (tipoUsuarioGateway.existsByDescricao(tipoUsuario.descricao())) {
            log.error("Tipo de Usuário já cadastrado com essa descrição: {}", tipoUsuario.descricao());
            throw new RegraDeNegocioException("Tipo de Usuário já cadastrado com essa descrição!");
        }
    }
}