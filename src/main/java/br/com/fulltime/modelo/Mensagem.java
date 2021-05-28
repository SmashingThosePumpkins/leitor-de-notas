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
        var formatado = Formatacao.aluno(aluno);
        this.aluno = formatado;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        var formatado = Formatacao.disciplina(disciplina);
        this.disciplina = formatado;
    }

    public double getPrimeiraNota() {
        return Double.parseDouble(this.primeiraNota);
    }

    public void setPrimeiraNota(String nota) {

        var valor = Formatacao.nota(nota);
        var validado = validacaoNota(valor);
        var formatado = doubleFormatNota(valor);

        if(validado) {
            this.primeiraNota = formatado + "";
        }
    }

    public double getSegundaNota() {
        return Double.parseDouble(this.segundaNota);
    }

    public void setSegundaNota(String nota) {

        var valor = Formatacao.nota(nota);
        var validado = validacaoNota(valor);
        var formatado = doubleFormatNota(valor);

        if(validado) {
            this.segundaNota = formatado + "";
        }
    }

    private double doubleFormatNota(String nota){

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

    private boolean validacaoNota(String nota){

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
