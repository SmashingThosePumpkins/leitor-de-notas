package br.com.fulltime.modelo;

public class Aluno {

    private String identificador;
    private String nomeAluno;

    public Aluno() {
        this.setIdentificador("0");
        this.setNomeAluno("n/a");
    }

    public Aluno(String identificador, String nomeAluno) {
        this.setIdentificador(identificador);
        this.setNomeAluno(nomeAluno);
    }

    public long getIdentificador() {
        return Long.parseLong(identificador);
    }

    public void setIdentificador(String identificador) {

        String semArroba;
        if (identificador.contains("@")) {
            semArroba = identificador.substring(1);
        } else {
            semArroba = identificador;
        }

        if (semArroba.length() > 6) {
            throw new StringIndexOutOfBoundsException("Identificador inválido.");
        }
        try {
            Long.parseLong(semArroba);
        } catch (NumberFormatException e) {
            throw new StringIndexOutOfBoundsException("Identificador inválido.");
        }
        this.identificador = semArroba;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        if (nomeAluno == null) {
            throw new NullPointerException("Nome do aluno nulo.");
        }
        if (!(nomeAluno.length() <= 20)) {
            throw new StringIndexOutOfBoundsException("O limite para o nome é de vinte caracteres.");
        }
        this.nomeAluno = nomeAluno;
    }
}
