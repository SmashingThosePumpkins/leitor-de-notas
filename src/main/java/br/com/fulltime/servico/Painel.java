package br.com.fulltime.servico;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Mensagem;
import br.com.fulltime.modelo.UserOptions;

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
            var option = UserOptions.getFromValue(input);

            switch (option) {
                // Caso o usuário queira checar todas as notas
                case VISUALIZAR_NOTAS -> {
                    try {

                        lista = Interpretador.getNotas();
                        var displayText = new StringBuilder();
                        lista.forEach(displayText::append);

                        JOptionPane.showMessageDialog(null, displayText.toString());

                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
                        e.printStackTrace();
                    }
                }

                // Caso o usuário queira adicionar uma nova nota
                case ADICIONAR_NOTAS -> {
                    var aluno = new Aluno();
                    var mensagem = new Mensagem();

                    try {
                        aluno.setNomeAluno(JOptionPane.showInputDialog(null, "Digite o nome do aluno (Limite de vinte caracteres)."));
                        aluno.setIdentificador(JOptionPane.showInputDialog(null, "Digite o identificador do aluno (Seis números)."));
                        mensagem.setDisciplina(JOptionPane.showInputDialog(null, "Digite a disciplina."));
                        mensagem.setPrimeiraNota(JOptionPane.showInputDialog(null, "Digite a primeira nota.\nExemplos: [9.5], [6], [10.0]."));
                        mensagem.setSegundaNota(JOptionPane.showInputDialog(null, "Digite a segunda nota.\nExemplos: [9.5], [6], [10.0]."));
                        mensagem.setAluno(aluno);
                        var imprimiu = ManuseamentoArquivo.imprimirMensagem(mensagem);
                        if (imprimiu) {
                            JOptionPane.showMessageDialog(null, "Nova nota cadastrada com sucesso.");
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    } catch (IOException | NullPointerException e) {
                        e.printStackTrace();
                    }
                }

                // Caso o usuário queira deletar uma nota
                case DELETAR_LINHA -> {

                    try {
                        long identificador = Long.parseLong(JOptionPane.showInputDialog(null,
                                "Digite o identificador do aluno (número de seis dígitos).").trim());
                        String disciplina = JOptionPane.showInputDialog(null, "Digite a disciplina.").trim();
                        ManuseamentoArquivo.limparLinha(identificador, disciplina);
                    } catch (NumberFormatException e) {
                        if (e.getMessage().equals("null")) {
                            e.printStackTrace();
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi digitado um número. Tente novamente.");
                        }
                    } catch (NullPointerException | IOException e) {
                        e.printStackTrace();
                    }
                }

                default -> rodando = false;
            }
        }

        return lista;

    }

}
