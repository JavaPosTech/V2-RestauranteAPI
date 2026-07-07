package br.com.fiap.restauranteapi.core.controller;

import br.com.fiap.restauranteapi.core.domain.cardapio.Cardapio;
import br.com.fiap.restauranteapi.core.dto.cardapio.CardapioDTO;
import br.com.fiap.restauranteapi.core.dto.response.MensagemSucessoResponse;
import br.com.fiap.restauranteapi.core.usecase.cardapio.atualizar.AtualizarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.criar.CriarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.deletar.DeletarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.listar.ListarCardapioUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CardapioController {

    private final CriarCardapioUseCase criarCardapioUseCase;

    private final ListarCardapioUseCase listarCardapioUseCase;

    private final AtualizarCardapioUseCase atualizarCardapioUseCase;

    private final DeletarCardapioUseCase deletarCardapioUseCase;

    public List<CardapioDTO> listar() {
        return listarCardapioUseCase.executar();
    }

    public List<CardapioDTO> listarPorRestaurante(Integer restauranteId) {
        return listarCardapioUseCase.executarPorRestaurante(restauranteId);
    }

    public MensagemSucessoResponse salvar(Cardapio cardapio) {
        return criarCardapioUseCase.executar(cardapio);
    }

    public MensagemSucessoResponse atualizar(Integer id, Cardapio cardapio) {
        return atualizarCardapioUseCase.executar(id, cardapio);
    }

    public void deletar(Integer id, Integer usuarioId) {
        deletarCardapioUseCase.executar(id, usuarioId);
    }
}