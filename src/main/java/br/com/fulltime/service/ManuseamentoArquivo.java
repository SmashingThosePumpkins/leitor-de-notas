package br.com.fulltime.service;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Arquivo;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManuseamentoArquivo {


    public static void imprimirMensagem(Aluno aluno, Mensagem mensagem) throws IOException {
        // Pegar os dados necessários para o cadastro
        aluno.setNomeAluno(JOptionPane.showInputDialog(null, "Digite o nome do aluno."));
        aluno.setIdentificador(JOptionPane.showInputDialog(null, "Digite o identificador do aluno."));
        mensagem.setDisciplina(JOptionPane.showInputDialog(null, "Digite a disciplina."));
        mensagem.setPrimeiraNota(JOptionPane.showInputDialog(null, "Digite a primeira nota."));
        mensagem.setSegundaNota(JOptionPane.showInputDialog(null, "Digite a segunda nota."));
        mensagem.setAluno(aluno);

        // Construir a nova linha
        var stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        stringBuilder.append(String.format("%06d", mensagem.getIdentificador()));
        stringBuilder.append(';');
        stringBuilder.append(mensagem.getNomeAluno());
        stringBuilder.append(';');
        stringBuilder.append(mensagem.getDisciplina());
        stringBuilder.append(";N1");
        var n1 = (int) (mensagem.getPrimeiraNota() * 10000);
        stringBuilder.append(String.format("%04d", n1));
        stringBuilder.append(";N2");
        var n2 = (int) (mensagem.getSegundaNota() * 10000);
        stringBuilder.append(String.format("%04d", n2));
        stringBuilder.append('|');
        stringBuilder.append('\n');

        // Anexar a nova linha ao arquivo de texto

        var bufferedWriter = new BufferedWriter(new FileWriter(Arquivo.NOTAS_ALUNOS, true));
        bufferedWriter.append(stringBuilder);
        bufferedWriter.close();
    }
}
