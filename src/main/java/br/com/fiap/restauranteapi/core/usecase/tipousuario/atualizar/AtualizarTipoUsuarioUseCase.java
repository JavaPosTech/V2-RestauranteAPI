package br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.exceptions.RegistroNaoEncontradoException;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AtualizarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public MensagemSucessoResponse executar(Integer id, TipoUsuario tipoUsuario) {
        validarExistencia(id);

        validarDescricaoUnica(tipoUsuario.getDescricao(), id);

        tipoUsuarioGateway.save(new TipoUsuario(id, tipoUsuario.getDescricao()));
        return new MensagemSucessoResponse(200, "Tipo de Usuário atualizado com sucesso!");
    }

    private void validarExistencia(Integer id) {
        if (tipoUsuarioGateway.findById(id).isEmpty()) {
            log.error("O Tipo Usuário solicitado não foi encontrado! ID: {}", id);
            throw new RegistroNaoEncontradoException("O Tipo Usuário solicitado não foi encontrado!");
        }
    }

    private void validarDescricaoUnica(String descricao, Integer id) {
        if (tipoUsuarioGateway.existsByDescricaoAndIdNot(descricao, id)) {
            log.error("Já existe um Tipo de Usuário com a descrição informada! Descrição: {}", descricao);
            throw new RegraDeNegocioException("Já existe um Tipo de Usuário com a descrição informada!");
        }
    }
}