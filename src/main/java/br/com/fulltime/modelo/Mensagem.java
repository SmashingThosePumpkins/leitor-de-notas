package br.com.fulltime.modelo;

public class Mensagem {

    private Aluno aluno = new Aluno("0", "n/a");
    private String disciplina = "n/a";
    private String primeiraNota = "0";
    private String segundaNota = "0";

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
        if (!(disciplina.length() <= 20)) {
            throw new StringIndexOutOfBoundsException("O limite para o nome da disciplina é de vinte caracteres.");
        }
        this.disciplina = disciplina;
    }

    public double getPrimeiraNota() {
        return Double.parseDouble(this.primeiraNota);
    }

    public void setPrimeiraNota(String primeiraNota) {

        // Remoção do "N1" caso a String fornecida contenha.
        String semN1;
        if (primeiraNota.contains("N1")) {
            semN1 = primeiraNota.substring(2);
        } else {
            semN1 = primeiraNota;
        }

        var validado = validacao(semN1);
        var nota = doubleformat(semN1);

        if(validado) {
            this.primeiraNota = nota + "";
        }
    }

    public double getSegundaNota() {
        return Double.parseDouble(this.segundaNota);
    }

    public void setSegundaNota(String segundaNota) {

        // Remoção do "N1" caso a String fornecida contenha.
        String semN2;
        if (segundaNota.contains("N2")) {
            semN2 = segundaNota.substring(2);
        } else {
            semN2 = segundaNota;
        }

        var validado = validacao(semN2);
        var nota = doubleformat(semN2);

        if(validado) {
            this.segundaNota = nota + "";
        }
    }

    private double doubleformat(String nota){

        var notaDouble = Double.parseDouble(nota);

        // Se a nota for maior que 10.0 (caso esteja no formato 1000), divida por 100
        if(notaDouble > 10.0) {
            notaDouble /= 100.0;
        }

        // Se a nota continuar maior que 10.0, jogue uma exceção
        if(notaDouble > 10.0){
            throw new StringIndexOutOfBoundsException("A nota máxima é 10, a provida foi " + notaDouble);
        }

        return notaDouble;
    }

    private boolean validacao(String nota){

        if (nota == null) {
            return false;
        }
        try {
            Double.parseDouble(nota);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + String.format("%06d", getIdentificador()) + "] " +
                getNomeAluno() +
                " - " + getDisciplina() +
                " (" + getPrimeiraNota() +
                " / " + getSegundaNota() + ")\n";
    }

    public String toFormattedString() {
        var formatted = new StringBuilder();
        formatted.append('@');
        formatted.append(String.format("%06d", this.getIdentificador()));
        formatted.append(';');
        formatted.append(this.getNomeAluno());
        formatted.append(';');
        formatted.append(this.getDisciplina());
        formatted.append(";N1");
        var n1 = (int) (this.getPrimeiraNota() * 100.0);
        formatted.append(String.format("%04d", n1));
        formatted.append(";N2");
        var n2 = (int) (this.getSegundaNota() * 100.0);
        formatted.append(String.format("%04d", n2));
        formatted.append('|');
        formatted.append('\n');
        return formatted.toString();
    }
}
