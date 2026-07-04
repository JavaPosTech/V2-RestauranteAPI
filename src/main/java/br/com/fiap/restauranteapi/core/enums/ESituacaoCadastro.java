package br.com.fiap.restauranteapi.core.enums;

import br.com.fiap.restauranteapi.core.exceptions.RegraDeNegocioException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ESituacaoCadastro {

    ATIVO(1, "ATIVO"),
    EXCLUIDO(2, "EXCLUIDO");

    private final Integer codigo;
    private final String descricao;

    ESituacaoCadastro(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static ESituacaoCadastro fromCodigo(Integer codigo) {
        if (codigo == null) {
            throw new RegraDeNegocioException("A Situação do Cadastro é obrigatória!");
        }

        return Arrays.stream(values())
                .filter(situacao -> situacao.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException(
                        "Situação do Cadastro inválida! Valores permitidos: 1 - ATIVO, 2 - EXCLUIDO."
                ));
    }
}