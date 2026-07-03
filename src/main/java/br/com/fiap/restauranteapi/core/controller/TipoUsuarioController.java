package br.com.fiap.restauranteapi.core.controller;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.dto.tipousuario.TipoUsuarioDTO;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar.AtualizarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.criar.CriarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar.DeletarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.listar.ListarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TipoUsuarioController {

    private final CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;

    private final ListarTipoUsuarioUseCase listarTipoUsuarioUseCase;

    private final DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase;

    private final AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase;

    public List<TipoUsuarioDTO> listar() {
        return listarTipoUsuarioUseCase.executar();
    }

    public MensagemSucessoResponse salvar(TipoUsuario tipoUsuario) {
        return criarTipoUsuarioUseCase.executar(tipoUsuario);
    }

    public MensagemSucessoResponse atualizar(Integer id, TipoUsuario tipoUsuario) {
        return atualizarTipoUsuarioUseCase.executar(id, tipoUsuario);
    }

    public void deletar(Integer id) {
        deletarTipoUsuarioUseCase.executar(id);
    }
}