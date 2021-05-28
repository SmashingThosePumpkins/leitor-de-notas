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

        var formatado = Formatacao.identificador(identificador);
        this.identificador = formatado;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {

        var formatado = Formatacao.nomeAluno(nomeAluno);
        this.nomeAluno = nomeAluno;
    }
}
