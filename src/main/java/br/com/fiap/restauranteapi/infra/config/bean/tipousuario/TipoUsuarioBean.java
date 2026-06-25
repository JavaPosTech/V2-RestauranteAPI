package br.com.fiap.restauranteapi.infra.config.bean.tipousuario;

import br.com.fiap.restauranteapi.core.controller.TipoUsuarioController;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.atualizar.AtualizarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.criar.CriarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.deletar.DeletarTipoUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.tipousuario.listar.ListarTipoUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoUsuarioBean {

    @Bean
    public CriarTipoUsuarioUseCase criarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        return new CriarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    @Bean
    public ListarTipoUsuarioUseCase buscarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        return new ListarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    @Bean
    public AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        return new AtualizarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    @Bean
    public DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        return new DeletarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    @Bean
    public TipoUsuarioController tipoUsuarioController(
            CriarTipoUsuarioUseCase criarTipoUsuarioUseCase,
            ListarTipoUsuarioUseCase listarTipoUsuarioUseCase,
            DeletarTipoUsuarioUseCase deletarTipoUsuarioUseCase,
            AtualizarTipoUsuarioUseCase atualizarTipoUsuarioUseCase
    ) {
        return new TipoUsuarioController(
                criarTipoUsuarioUseCase,
                listarTipoUsuarioUseCase,
                deletarTipoUsuarioUseCase,
                atualizarTipoUsuarioUseCase
        );
    }
}