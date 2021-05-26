package br.com.fulltime.modelo;

public class Mensagem {

    private Aluno aluno = new Aluno("0", "n/a");
    private String disciplina = "n/a";
    private String primeiraNota = "n/a";
    private String segundaNota = "n/a";

    public Mensagem() {

    }

    public long getIdentificador() {
        return this.aluno.getIdentificador();
    }

    public String getNomeAluno() {
        return this.aluno.getNomeAluno();
    }

    public void setAluno(String identificador, String nome) {
        this.aluno.setNomeAluno(nome);
        this.aluno.setIdentificador(identificador);
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new NullPointerException("Aluno nulo.");
        }
        if (!(aluno.getNomeAluno().length() <= 20)) {
            throw new StringIndexOutOfBoundsException("O limite para o nome é de vinte caracteres.");
        }
        this.aluno = aluno;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina == null) {
            throw new NullPointerException("Disciplina nula.");
        }
        this.disciplina = disciplina;
    }

    public double getPrimeiraNota() {
        var valor = Double.parseDouble(this.primeiraNota.replace("N1", ""));
        return valor / 100;
    }

    public void setPrimeiraNota(String primeiraNota) {

        String semN1;
        if (primeiraNota.contains("N1")) {
            semN1 = primeiraNota.substring(2);
        } else {
            semN1 = primeiraNota;
        }

        if (semN1 == null) {
            throw new NullPointerException("Valor nulo.");
        }
        try {
            var parseado = Double.parseDouble(semN1);
            if (parseado > 1000) {
                throw new StringIndexOutOfBoundsException("A maior nota possível é 10. A nota passada foi " + parseado);
            }
        } catch (NumberFormatException e) {
            throw new StringIndexOutOfBoundsException("Número inválido.");
        }
        this.primeiraNota = semN1;
    }

    public double getSegundaNota() {
        var valor = Double.parseDouble(this.segundaNota.replace("N2", ""));
        return valor / 100;
    }

    public void setSegundaNota(String segundaNota) {
        if (segundaNota == null) {
            throw new NullPointerException("Valor nulo.");
        }
        this.segundaNota = segundaNota;
    }

    @Override
    public String toString() {
        return  "[" + String.format("%06d", getIdentificador()) + "] " +
                getNomeAluno() +
                " - " + getDisciplina() +
                " (" + getPrimeiraNota() +
                " / " + getSegundaNota() + ")\n";
    }
}
