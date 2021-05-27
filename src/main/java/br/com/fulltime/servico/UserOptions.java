package br.com.fulltime.servico;

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

    public static UserOptions getFromValue(int value){
//        if(VISUALIZAR_NOTAS.value == value){
//            return VISUALIZAR_NOTAS;
//        }
//        if(ADICIONAR_NOTAS.value == value){
//            return ADICIONAR_NOTAS;
//        }
//        if(DELETAR_LINHA.value == value){
//            return DELETAR_LINHA;
//        }
//        return UNKNOWN;
        return Stream.of(UserOptions.values())
                .filter(opt -> opt.value == value)
                .findFirst()
                .orElse(UNKNOWN);
    }


}
