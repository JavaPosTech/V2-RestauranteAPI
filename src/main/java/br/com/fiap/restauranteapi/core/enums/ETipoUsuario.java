package br.com.fiap.restauranteapi.core.enums;

import lombok.Getter;

@Getter
public enum ETipoUsuario {

    CLIENTE(1),
    DONO_RESTAURANTE(2);

    private final Integer codigo;

    ETipoUsuario(Integer codigo) {
        this.codigo = codigo;
    }
}