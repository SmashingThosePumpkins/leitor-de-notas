package br.com.fulltime.modelo;

public class Mensagem {

    private Aluno aluno = new Aluno("n/a", "n/a");
    private String disciplina = "n/a";
    private String primeiraNota = "n/a";
    private String segundaNota = "n/a";

    public Mensagem() {
//        this.aluno = aluno;
//        this.disciplina = disciplina;
//        this.primeiraNota = primeiraNota;
//        this.segundaNota = segundaNota;
    }

    public String getIdentificador() {
        return this.aluno.getIdentificador();
    }

    public String getNomeAluno() {
        return this.aluno.getNomeAluno();
    }

    public void setAluno(String identificador, String nome) {
        this.aluno.setNomeAluno(nome);
        this.aluno.setIdentificador(identificador);
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPrimeiraNota() {
        return this.primeiraNota;
    }

    public void setPrimeiraNota(String primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public String getSegundaNota() {
        return this.segundaNota;
    }

    public void setSegundaNota(String segundaNota) {
        this.segundaNota = segundaNota;
    }

    @Override
    public String toString() {
        return "Mensagem: " +
                "{Nome = " + getNomeAluno() +
                ", Matéria = " + disciplina + '\'' +
                ", Primeira Nota = " + primeiraNota + '\'' +
                ", Segunda nota = " + segundaNota + '\'' +
                ", ID = " + getIdentificador() + '\'' +
                '}';
    }
}
