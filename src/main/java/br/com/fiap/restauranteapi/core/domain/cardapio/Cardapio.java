package br.com.fiap.restauranteapi.core.domain.cardapio;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Cardapio {

    private Integer id;
    private Restaurante restaurante;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean consumoLocal;
    private String foto;

    public Cardapio(
            Integer id,
            Restaurante restaurante,
            String nome,
            String descricao,
            BigDecimal preco,
            boolean consumoLocal,
            String foto
    ) {
        validarId(id);
        validarRestaurante(restaurante);
        validarNome(nome);
        validarPreco(preco);

        this.id = id;
        this.restaurante = restaurante;
        this.nome = nome.trim();
        this.descricao = descricao;
        this.preco = preco;
        this.consumoLocal = consumoLocal;
        this.foto = foto;
    }

    public void atualizarDados(
            String nome,
            String descricao,
            BigDecimal preco,
            boolean consumoLocal,
            String foto
    ) {
        validarNome(nome);
        validarPreco(preco);

        this.nome = nome.trim();
        this.descricao = descricao;
        this.preco = preco;
        this.consumoLocal = consumoLocal;
        this.foto = foto;
    }

    public boolean pertenceAoRestaurante(Integer restauranteId) {
        return restaurante != null && restaurante.getId() != null && restaurante.getId().equals(restauranteId);
    }

    public boolean possuiPrecoValido() {
        return preco != null && preco.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean permiteConsumoLocal() {
        return consumoLocal;
    }

    private void validarId(Integer id) {
        if (id != null && id <= 0) {
            throw new IllegalArgumentException("O id do cardápio deve ser maior que zero.");
        }
    }

    private void validarRestaurante(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("O restaurante é obrigatório.");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item do cardápio é obrigatório.");
        }

        if (nome.length() > 100) {
            throw new IllegalArgumentException("O nome do item do cardápio deve ter no máximo 100 caracteres.");
        }
    }

    private void validarPreco(BigDecimal preco) {
        if (preco == null) {
            throw new IllegalArgumentException("O preço do item do cardápio é obrigatório.");
        }

        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço do item do cardápio deve ser maior que zero.");
        }
    }
}