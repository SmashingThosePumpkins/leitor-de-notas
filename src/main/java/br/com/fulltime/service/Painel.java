package br.com.fulltime.service;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Arquivo;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Painel {

    public static ArrayList<Mensagem> painel() {

        ArrayList<Mensagem> lista = null;
        String[] options = {"Checar todas as notas", "Adicionar uma nova nota"};

        int input = JOptionPane.showOptionDialog(null, "O que deseja fazer?",
                "Escolha uma opção.",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (input) {
            case 0 -> {
                var interpretador = new Interpretador();
                try {

                    lista = interpretador.getNotas();
                    var displayText = new StringBuilder();
                    lista.forEach(displayText::append);

                    JOptionPane.showMessageDialog(null, displayText.toString());

                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
                    e.printStackTrace();
                }
            }

            case 1 -> {
                var aluno = new Aluno("n/a", "n/a");
                var mensagem = new Mensagem();

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

                // Anexar a nova linha ao arquivo de texto
                try {
                    var fileWriter = new FileWriter(Arquivo.NOTAS_ALUNOS);
                    fileWriter.append(stringBuilder);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Nova nota cadastrada com sucesso.");

            }

            default -> {
            }
        }

        return lista;

    }

}
