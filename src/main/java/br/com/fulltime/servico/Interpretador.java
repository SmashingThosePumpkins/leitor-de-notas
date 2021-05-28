package br.com.fulltime.servico;

import br.com.fulltime.modelo.*;

import java.util.*;
import java.io.*;

public class Interpretador {

    public static ArrayList<Mensagem> getNotas() throws FileNotFoundException {
        var lista = new ArrayList<Mensagem>();

        // Abrir Scanner
        Scanner leitor = new Scanner(new File(Arquivo.ARQUIVO_NOTAS));

        do {
            var mensagem = new Mensagem();

            // Ler linha e separar conteúdos em uma array
            var linha = leitor.nextLine();
            String[] mensagens = linha.split("\\|");

            for (String mensagen : mensagens) {
                String[] atributos = mensagen.split(";");

                // Inserir atributos da linha na classe Mensagem
                String identificador = atributos[Arquivo.ARRAY_IDENTIFICADOR_ALUNO];
                String nomeAluno = atributos[Arquivo.ARRAY_NOME_ALUNO];
                String atributo = atributos[Arquivo.ARRAY_DISCIPLINA];
                String primeiraNota = atributos[Arquivo.ARRAY_PRIMEIRA_NOTA];
                String segundaNota = atributos[Arquivo.ARRAY_SEGUNDA_NOTA].replace("|", "");

                mensagem.setAluno(identificador, nomeAluno);
                mensagem.setDisciplina(atributo);
                mensagem.setPrimeiraNota(primeiraNota);
                mensagem.setSegundaNota(segundaNota);

                // Adicionar mensagem na lista
                lista.add(mensagem);

            }

        } while (leitor.hasNextLine());

        return lista;

    }

}
