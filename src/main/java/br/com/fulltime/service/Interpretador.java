package br.com.fulltime.service;

import br.com.fulltime.modelo.*;

import java.util.*;
import java.io.*;

public class Interpretador {

    private final String NOTAS_ALUNOS = "src/main/resources/notas_alunos.txt";

    public ArrayList<Mensagem> interpretar() throws FileNotFoundException{
        var lista = new ArrayList<Mensagem>();

        // Abrir Scanner
        Scanner leitor = new Scanner(new File(NOTAS_ALUNOS));

        do {
            var mensagem = new Mensagem();

            // Ler linha e separar conteúdos em uma array
            var linha = leitor.nextLine();
            String[] atributos = linha.split(";");

            // Inserir atributos da linha na classe Mensagem fornecida
            mensagem.setAluno(atributos[0], atributos[1]);
            mensagem.setDisciplina(atributos[2]);
            mensagem.setPrimeiraNota(atributos[3]);
            mensagem.setSegundaNota(atributos[4]);

            // Adicionar mensagem na lista
            lista.add(mensagem);

        } while (leitor.hasNextLine());

        return lista;

    }

}
