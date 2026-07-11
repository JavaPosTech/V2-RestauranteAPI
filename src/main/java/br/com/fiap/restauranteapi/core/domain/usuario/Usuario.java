package br.com.fiap.restauranteapi.core.domain.usuario;

import br.com.fiap.restauranteapi.core.domain.tipousuario.TipoUsuario;
import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Usuario {

    private Integer id;

    private String nome;

    private String sobrenome;

    private TipoUsuario tipoUsuario;

    private LocalDateTime dataCriacao;

    private ESituacaoCadastro situacaoCadastro;

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(
            Integer id,
            String nome,
            String sobrenome,
            TipoUsuario tipoUsuario,
            LocalDateTime dataCriacao,
            ESituacaoCadastro situacaoCadastro
    ) {
        validarNomeObrigatorio(nome);
        validarSobrenomeObrigatorio(sobrenome);
        validarTipoUsuarioObrigatorio(tipoUsuario);

        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoUsuario = tipoUsuario;
        this.dataCriacao = dataCriacao;
        this.situacaoCadastro = situacaoCadastro == null ? ESituacaoCadastro.ATIVO : situacaoCadastro;
    }

    private Usuario(String nome, String sobrenome, TipoUsuario tipoUsuario) {
        validarAoMenosUmCampo(nome, sobrenome, tipoUsuario.getId());
        validarNomeSeInformado(nome);
        validarSobrenomeSeInformado(sobrenome);

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoUsuario = tipoUsuario;
    }

    public static Usuario criar(String nome, String sobrenome, TipoUsuario tipoUsuario) {
        return new Usuario(
                null,
                nome,
                sobrenome,
                tipoUsuario,
                null,
                ESituacaoCadastro.ATIVO
        );
    }

    public static Usuario atualizar(String nome, String sobrenome, TipoUsuario tipoUsuario) {
        return new Usuario(nome, sobrenome, tipoUsuario);
    }

    private void validarNomeObrigatorio(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RegraDeNegocioException("O nome do Usuário é obrigatório!");
        }
    }

    private void validarSobrenomeObrigatorio(String sobrenome) {
        if (sobrenome == null || sobrenome.isBlank()) {
            throw new RegraDeNegocioException("O sobrenome do Usuário é obrigatório!");
        }
    }

    private void validarTipoUsuarioObrigatorio(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null || tipoUsuario.getId() == null) {
            throw new RegraDeNegocioException("O Tipo de Usuário é obrigatório!");
        }
    }

    private void validarAoMenosUmCampo(String nome, String sobrenome, Integer tipoUsuarioId) {
        if (nome == null && sobrenome == null && tipoUsuarioId == null) {
            throw new RegraDeNegocioException("Informe ao menos um campo para atualizar o Usuário!");
        }
    }

    private void validarNomeSeInformado(String nome) {
        if (nome != null && nome.isBlank()) {
            throw new RegraDeNegocioException("O nome do Usuário não pode ser vazio!");
        }
    }

    private void validarSobrenomeSeInformado(String sobrenome) {
        if (sobrenome != null && sobrenome.isBlank()) {
            throw new RegraDeNegocioException("O sobrenome do Usuário não pode ser vazio!");
        }
    }
}