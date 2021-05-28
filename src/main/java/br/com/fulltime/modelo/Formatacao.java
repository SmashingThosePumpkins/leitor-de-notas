package br.com.fulltime.modelo;

public class Formatacao {

    public static String identificador(String identificador) {
        String formatado;
        if (identificador.contains("@")) {
            formatado = identificador.substring(1);
        } else {
            formatado = identificador;
        }

        if (formatado.length() > 6) {
            throw new StringIndexOutOfBoundsException("Identificador inválido.");
        }
        try {
            Long.parseLong(formatado);
        } catch (NumberFormatException e) {
            throw new StringIndexOutOfBoundsException("Identificador inválido.");
        }

        return formatado;
    }

    public static String nomeAluno(String nomeAluno) {
        if (nomeAluno == null) {
            throw new NullPointerException("Nome do aluno nulo.");
        }
        if (!(nomeAluno.length() <= 20)) {
            throw new StringIndexOutOfBoundsException("O limite para o nome é de vinte caracteres.");
        }

        // Como não há regras de formatação para o aluno, será retornado o original
        return nomeAluno;
    }
}
