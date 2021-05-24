package br.com.fulltime.modelo;

public class Aluno {

    String identificador;
    String nomeAluno;

    public Aluno(String identificador, String nomeAluno) {
        this.identificador = identificador;
        this.nomeAluno = nomeAluno;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
