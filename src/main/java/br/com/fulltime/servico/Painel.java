package br.com.fulltime.servico;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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
                        lista.forEach(displayText::append);

                        JOptionPane.showMessageDialog(null, displayText.toString());

                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
                        e.printStackTrace();
                    }
                }

                // Caso o usuário queira adicionar uma nova nota
                case 1 -> {
                    var aluno = new Aluno("0", "n/a");
                    var mensagem = new Mensagem();

                    try {
                        var imprimiu = ManuseamentoArquivo.imprimirMensagem(aluno, mensagem);
                        if (imprimiu) {
                            JOptionPane.showMessageDialog(null, "Nova nota cadastrada com sucesso.");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // Caso o usuário queira deletar uma nota
                case 2 -> {

                    try {
                        ManuseamentoArquivo.limparLinha();
                    } catch (NumberFormatException e) {
                        if (e.getMessage().equals("null")) {
                        e.printStackTrace();}
                        else {
                            JOptionPane.showMessageDialog(null, "Não foi digitado um número. Tente novamente.");
                        }
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
