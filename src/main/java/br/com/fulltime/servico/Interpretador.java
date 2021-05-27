package br.com.fulltime.servico;

import br.com.fulltime.modelo.*;

import java.util.*;
import java.io.*;

public class Interpretador {

    public ArrayList<Mensagem> getNotas() throws FileNotFoundException{
        var lista = new ArrayList<Mensagem>();

        // Abrir Scanner
        Scanner leitor = new Scanner(new File(Arquivo.ARQUIVO_NOTAS));

        do {
            var mensagem = new Mensagem();

            // Ler linha e separar conteúdos em uma array
            var linha = leitor.nextLine();
            String[] atributos = linha.split(";");

            // Inserir atributos da linha na classe Mensagem
            mensagem.setAluno(atributos[Arquivo.ARRAY_IDENTIFICADOR_ALUNO], atributos[Arquivo.ARRAY_NOME_ALUNO]);
            mensagem.setDisciplina(atributos[Arquivo.ARRAY_DISCIPLINA]);
            mensagem.setPrimeiraNota(atributos[Arquivo.ARRAY_PRIMEIRA_NOTA]);
            mensagem.setSegundaNota(atributos[Arquivo.ARRAY_SEGUNDA_NOTA].replace("|", ""));

            // Adicionar mensagem na lista
            lista.add(mensagem);

        } while (leitor.hasNextLine());

        return lista;

    }

}
