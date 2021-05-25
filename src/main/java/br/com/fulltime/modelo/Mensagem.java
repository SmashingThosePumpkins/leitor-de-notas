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

    public double getPrimeiraNota() {
        var valor = Double.parseDouble(this.primeiraNota.replace("N1", ""));
        return valor / 100;
    }

    public void setPrimeiraNota(String primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public double getSegundaNota() {
        var valor = Double.parseDouble(this.segundaNota.replace("N2", ""));
        return valor / 100;
    }

    public void setSegundaNota(String segundaNota) {
        this.segundaNota = segundaNota;
    }

    @Override
    public String toString() {
        return  "[" + getIdentificador() + "] " +
                getNomeAluno() +
                " - " + getDisciplina() +
                " (" + getPrimeiraNota() +
                " / " + getSegundaNota() + ")\n";
    }
}
