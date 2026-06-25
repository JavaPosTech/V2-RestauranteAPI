package br.com.fiap.restauranteapi.core.domain.cardapio;

import br.com.fiap.restauranteapi.core.domain.restaurante.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Cardapio {

    private Integer id;

    private Restaurante restaurante;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private boolean consumoLocal;

    private String foto;

}