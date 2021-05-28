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

        return nomeAluno;
    }

    public static Aluno aluno(Aluno aluno) {
        var nome = nomeAluno(aluno.getNomeAluno());
        var id = identificador(aluno.getIdentificador() + "");

        aluno.setNomeAluno(nome);
        aluno.setIdentificador(id);

        return aluno;
    }

    public static String nota(String nota) {

        if (nota.contains("N2") || nota.contains("N1")) {
            nota = nota.substring(2);
        }

        return nota;
    }

    public static String disciplina(String disciplina) {
        if (disciplina == null) {
            throw new NullPointerException("Disciplina nula.");
        }
        if (!(disciplina.length() <= 20)) {
            throw new StringIndexOutOfBoundsException("O limite para o nome da disciplina é de vinte caracteres.");
        }

        return disciplina;
    }
}
