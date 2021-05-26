package br.com.fulltime.service;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Arquivo;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class Painel {

    public static ArrayList<Mensagem> painel() {

        boolean rodando = true;
        ArrayList<Mensagem> lista = null;
        String[] options = {"Checar todas as notas", "Adicionar uma nova nota", "Deletar uma nota", "Sair"};

        while (rodando) {

            int input = JOptionPane.showOptionDialog(null, "O que deseja fazer?",
                    "Escolha uma opção.",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (input) {
                // Caso o usuário queira checar todas as notas
                case 0 -> {
                    var interpretador = new Interpretador();
                    try {

                        lista = interpretador.getNotas();
                        var displayText = new StringBuilder();
                        lista.forEach((item) -> displayText.append(item));

                        JOptionPane.showMessageDialog(null, displayText.toString());

                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
                        e.printStackTrace();
                    }
                }

                // Caso o usuário queira adicionar uma nova nota
                case 1 -> {
                    var aluno = new Aluno("n/a", "n/a");
                    var mensagem = new Mensagem();

                    try {
                        ManuseamentoArquivo.imprimirMensagem(aluno, mensagem);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Nova nota cadastrada com sucesso.");

                }

                // Caso o usuário queira deletar uma nota
                case 2 -> {
                    var inputIdentificador = JOptionPane.showInputDialog(null, "Digite o identificador do aluno (número de seis dígitos).");
                    var inputDisciplina = JOptionPane.showInputDialog(null, "Digite a disciplina.");

                    try {
                        ManuseamentoArquivo.limparLinha(Long.parseLong(inputIdentificador), inputDisciplina);
                    } catch (IllegalFormatException e) {
                        JOptionPane.showMessageDialog(null, "Não foi digitado um número. Tente novamente.");
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                default -> rodando = false;
            }
        }

        return lista;

    }

}
