package br.com.fulltime.modelo;

public class Mensagem {

    Aluno aluno;
    String disciplina;
    double primeiraNota;
    double segundaNota;

    public Mensagem(Aluno aluno, String disciplina, double primeiraNota, double segundaNota) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(double primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(double segundaNota) {
        this.segundaNota = segundaNota;
    }
}
