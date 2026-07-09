package br.com.fiap.restauranteapi.core.domain.usuario;

import br.com.fiap.restauranteapi.core.enums.ESituacaoCadastro;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Usuario {

    private Integer id;

    private String nome;

    private String sobrenome;

    private Integer tipoUsuarioId;

    private LocalDateTime dataCriacao;

    private ESituacaoCadastro situacaoCadastro;

    public Usuario(
            Integer id,
            String nome,
            String sobrenome,
            Integer tipoUsuarioId,
            LocalDateTime dataCriacao,
            ESituacaoCadastro situacaoCadastro
    ) {
        validarNomeObrigatorio(nome);
        validarSobrenomeObrigatorio(sobrenome);
        validarTipoUsuarioObrigatorio(tipoUsuarioId);
        validarTipoUsuarioPermitido(tipoUsuarioId);

        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoUsuarioId = tipoUsuarioId;
        this.dataCriacao = dataCriacao;
        this.situacaoCadastro = situacaoCadastro == null ? ESituacaoCadastro.ATIVO : situacaoCadastro;
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    private Usuario(String nome, String sobrenome, Integer tipoUsuarioId) {
        validarAoMenosUmCampo(nome, sobrenome, tipoUsuarioId);
        validarNomeSeInformado(nome);
        validarSobrenomeSeInformado(sobrenome);

        if (tipoUsuarioId != null) {
            validarTipoUsuarioPermitido(tipoUsuarioId);
        }

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public static Usuario criar(String nome, String sobrenome, Integer tipoUsuarioId) {
        return new Usuario(
                null,
                nome,
                sobrenome,
                tipoUsuarioId,
                null,
                ESituacaoCadastro.ATIVO);
    }

    public static Usuario atualizar(String nome, String sobrenome, Integer tipoUsuarioId) {
        return new Usuario(nome, sobrenome, tipoUsuarioId);
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

    private void validarTipoUsuarioObrigatorio(Integer tipoUsuarioId) {
        if (tipoUsuarioId == null) {
            throw new RegraDeNegocioException("O Tipo de Usuário é obrigatório!");
        }
    }

    // Validar no UseCase
    private void validarTipoUsuarioPermitido(Integer tipoUsuarioId) {
        if (!tipoUsuarioId.equals(1) && !tipoUsuarioId.equals(2)) {
            throw new RegraDeNegocioException("Tipo de Usuário inválido!");
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