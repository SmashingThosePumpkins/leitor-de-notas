package br.com.fulltime.modelo;

import java.util.stream.Stream;

public enum UserOptions {

    VISUALIZAR_NOTAS(0),
    ADICIONAR_NOTAS(1),
    DELETAR_LINHA(2),
    UNKNOWN(-1);

    private final int value;

    UserOptions(int value) {
        this.value = value;
    }

    public static UserOptions getFromValue(int value) {
        return Stream.of(UserOptions.values())
                .filter(opt -> opt.value == value)
                .findFirst()
                .orElse(UNKNOWN);
    }


}
