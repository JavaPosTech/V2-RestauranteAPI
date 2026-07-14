package br.com.fiap.restauranteapi.core.domain.restaurante;

import br.com.fiap.restauranteapi.core.domain.usuario.Usuario;
import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@Getter
public class Restaurante {

    private Integer id;

    private Usuario usuario;

    private String nome;

    private String endereco;

    private String tipoCozinha;

    private String horaAbertura;

    private String horaFechamento;

    private LocalDateTime dataCriacao;

    public Restaurante(
            Integer id,
            Usuario usuario,
            String nome,
            String endereco,
            String tipoCozinha,
            String horaAbertura,
            String horaFechamento,
            LocalDateTime dataCriacao
    ) {
        validarUsuarioObrigatorio(usuario);
        validarNomeObrigatorio(nome);
        validarEnderecoObrigatorio(endereco);
        validarTipoCozinhaObrigatorio(tipoCozinha);
        validarHorarioFuncionamento(horaAbertura, horaFechamento);

        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.dataCriacao = dataCriacao;
    }

    public Restaurante(Integer id) {
        this.id = id;
    }

    public Restaurante(Integer id, Usuario usuario) {
        validarUsuarioObrigatorio(usuario);

        this.id = id;
        this.usuario = usuario;
    }

    public boolean pertenceAoUsuario(Integer usuarioId) {
        return this.usuario.getId().equals(usuarioId);
    }

    private void validarUsuarioObrigatorio(Usuario usuario) {
        if (usuario == null || usuario.getId() == null) {
            throw new RegraDeNegocioException("O Usuário do Restaurante é obrigatório!");
        }
    }

    private void validarNomeObrigatorio(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RegraDeNegocioException("O nome do Restaurante é obrigatório!");
        }
    }

    private void validarEnderecoObrigatorio(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            throw new RegraDeNegocioException("O endereço do Restaurante é obrigatório!");
        }
    }

    private void validarTipoCozinhaObrigatorio(String tipoCozinha) {
        if (tipoCozinha == null || tipoCozinha.isBlank()) {
            throw new RegraDeNegocioException("O tipo de cozinha do Restaurante é obrigatório!");
        }
    }

    private void validarHorarioFuncionamento(String horaAbertura, String horaFechamento) {
        LocalTime abertura = parseHorario(horaAbertura, "abertura");
        LocalTime fechamento = parseHorario(horaFechamento, "fechamento");

        if (!abertura.isBefore(fechamento)) {
            throw new RegraDeNegocioException("A hora de abertura deve ser anterior à hora de fechamento!");
        }
    }

    private LocalTime parseHorario(String horario, String campo) {
        if (horario == null || horario.isBlank()) {
            throw new RegraDeNegocioException("A hora de " + campo + " do Restaurante é obrigatória!");
        }

        try {
            return LocalTime.parse(horario);
        } catch (DateTimeParseException e) {
            throw new RegraDeNegocioException("A hora de " + campo + " do Restaurante é inválida! Formato esperado: HH:mm.");
        }
    }
}