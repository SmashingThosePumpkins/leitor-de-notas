package br.com.fulltime.servico;

import br.com.fulltime.modelo.Aluno;
import br.com.fulltime.modelo.Arquivo;
import br.com.fulltime.modelo.Mensagem;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ManuseamentoArquivo {

    private final static String ARQUIVO_TEXTO_TEMPORARIO = "src/main/resources/temp.txt";

    public static boolean imprimirMensagem(Mensagem mensagem) throws IOException {

        // Construir a nova linha
        var formattedString = mensagem.toFormattedString();

        // Anexar a nova linha ao arquivo de texto
        var bufferedWriter = new BufferedWriter(new FileWriter(Arquivo.ARQUIVO_NOTAS, true));
        bufferedWriter.append(formattedString);
        bufferedWriter.close();

        return true;

    }

    public static void limparLinha(long identificador, String disciplina) throws IOException {

        AtomicBoolean excluido = new AtomicBoolean(false);

        {
            // Ler linha por linha o conteúdo do arquivo de notas e passando para um arquivo temporário,
            // pulando o arquivo que contém o identificador provido

            var lista = Interpretador.getNotas();
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(ARQUIVO_TEXTO_TEMPORARIO));

            for (Mensagem mensagem : lista) {
                try {
                    if (mensagem.getIdentificador() == identificador && mensagem.getDisciplina().equals(disciplina)) {
                        excluido.set(true);
                    } else {
                        buffWriter.write(mensagem.toFormattedString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            buffWriter.flush();
            buffWriter.close();
        }
        {
            // Transferir o conteúdo do arquivo temporário para o principal

            Scanner scanner = new Scanner(new File(ARQUIVO_TEXTO_TEMPORARIO));
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(Arquivo.ARQUIVO_NOTAS));
            String valor;

            do {
                valor = scanner.nextLine();
                buffWriter.write(valor + "\n");
            } while (scanner.hasNext());

            buffWriter.flush();
            File temp = new File(ARQUIVO_TEXTO_TEMPORARIO);
            boolean delete = temp.delete();
            System.out.println(delete);
            buffWriter.close();
            scanner.close();

            if (excluido.get()) {
                JOptionPane.showMessageDialog(null, "Nota excluída com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a nota.\n" +
                        "Verifique se a disciplina e/ou o identificador foram digitados corretamente.");

            }

        }
    }
}
