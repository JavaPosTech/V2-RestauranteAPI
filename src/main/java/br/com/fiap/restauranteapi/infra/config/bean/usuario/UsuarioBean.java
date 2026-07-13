package br.com.fiap.restauranteapi.infra.config.bean.usuario;

import br.com.fiap.restauranteapi.core.controller.usuario.UsuarioController;
import br.com.fiap.restauranteapi.core.gateway.tipousuario.TipoUsuarioGateway;
import br.com.fiap.restauranteapi.core.gateway.usuario.UsuarioGateway;
import br.com.fiap.restauranteapi.core.usecase.usuario.atualizar.AtualizarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.criar.CriarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.deletar.DeletarUsuarioUseCase;
import br.com.fiap.restauranteapi.core.usecase.usuario.listar.ListarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioBean {

    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(UsuarioGateway usuarioGateway, TipoUsuarioGateway tipoUsuarioGateway) {
        return new CriarUsuarioUseCase(usuarioGateway, tipoUsuarioGateway);
    }

    @Bean
    public ListarUsuarioUseCase listarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        return new ListarUsuarioUseCase(usuarioGateway);
    }

    @Bean
    public AtualizarUsuarioUseCase atualizarUsuarioUseCase(UsuarioGateway usuarioGateway, TipoUsuarioGateway tipoUsuarioGateway) {
        return new AtualizarUsuarioUseCase(usuarioGateway, tipoUsuarioGateway);
    }

    @Bean
    public DeletarUsuarioUseCase deletarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        return new DeletarUsuarioUseCase(usuarioGateway);
    }

    @Bean
    public UsuarioController usuarioController(
            CriarUsuarioUseCase criarUsuarioUseCase,
            ListarUsuarioUseCase listarUsuarioUseCase,
            AtualizarUsuarioUseCase atualizarUsuarioUseCase,
            DeletarUsuarioUseCase deletarUsuarioUseCase
    ) {
        return new UsuarioController(
                criarUsuarioUseCase,
                listarUsuarioUseCase,
                atualizarUsuarioUseCase,
                deletarUsuarioUseCase
        );
    }
}