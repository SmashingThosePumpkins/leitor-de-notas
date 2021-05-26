package br.com.fulltime.service;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Arquivo;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.*;
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

                try {
                ManuseamentoArquivo.imprimirMensagem(aluno, mensagem);
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
