package br.com.fiap.restauranteapi.core.controller;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.dto.UsuarioDTO.UsuarioDTO;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.usecase.usuario.atualizar.AtualizarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.criar.CriarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.deletar.DeletarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.listar.ListarUsuarioUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;

    private final ListarUsuarioUseCase listarUsuarioUseCase;

    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    private final DeletarUsuarioUseCase deletarUsuarioUseCase;

    public List<UsuarioDTO> listar() {
        return listarUsuarioUseCase.executar();
    }

    public MensagemSucessoResponse salvar(Usuario usuario) {
        return criarUsuarioUseCase.executar(usuario);
    }

    public MensagemSucessoResponse atualizar(Integer id, Usuario usuario) {
        return atualizarUsuarioUseCase.executar(id, usuario);
    }

    public void deletar(Integer id) {
        deletarUsuarioUseCase.executar(id);
    }
}