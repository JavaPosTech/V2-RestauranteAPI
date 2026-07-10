package br.com.fiap.restauranteapi.infra.config.bean.cardapio;

import br.com.fiap.restauranteapi.core.controller.cardapio.CardapioController;
import br.com.fiap.restauranteapi.core.gateway.cardapio.CardapioGateway;
import br.com.fiap.restauranteapi.core.gateway.restaurante.RestauranteGateway;
import br.com.fiap.restauranteapi.core.usecase.cardapio.atualizar.AtualizarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.criar.CriarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.deletar.DeletarCardapioUseCase;
import br.com.fiap.restauranteapi.core.usecase.cardapio.listar.ListarCardapioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardapioBean {

    @Bean
    public CriarCardapioUseCase criarCardapioUseCase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        return new CriarCardapioUseCase(cardapioGateway, restauranteGateway);
    }

    @Bean
    public ListarCardapioUseCase listarCardapioUseCase(CardapioGateway cardapioGateway) {
        return new ListarCardapioUseCase(cardapioGateway);
    }

    @Bean
    public AtualizarCardapioUseCase atualizarCardapioUseCase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        return new AtualizarCardapioUseCase(cardapioGateway, restauranteGateway);
    }

    @Bean
    public DeletarCardapioUseCase deletarCardapioUseCase(CardapioGateway cardapioGateway, RestauranteGateway restauranteGateway) {
        return new DeletarCardapioUseCase(cardapioGateway, restauranteGateway);
    }

    @Bean
    public CardapioController cardapioController(
            CriarCardapioUseCase criarCardapioUseCase,
            ListarCardapioUseCase listarCardapioUseCase,
            AtualizarCardapioUseCase atualizarCardapioUseCase,
            DeletarCardapioUseCase deletarCardapioUseCase
    ) {
        return new CardapioController(
                criarCardapioUseCase,
                listarCardapioUseCase,
                atualizarCardapioUseCase,
                deletarCardapioUseCase
        );
    }
}