package br.com.fulltime.modelo;

public class Aluno {

    private String identificador;
    private String nomeAluno;

    public Aluno(String identificador, String nomeAluno) {
        this.identificador = identificador;
        this.nomeAluno = nomeAluno;
    }

    public long getIdentificador() {
        return Long.parseLong(identificador);
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
