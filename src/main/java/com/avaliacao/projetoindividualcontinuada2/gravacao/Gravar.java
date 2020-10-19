package com.avaliacao.projetoindividualcontinuada2.gravacao;

import com.avaliacao.projetoindividualcontinuada2.dominios.Campanha;
import com.avaliacao.projetoindividualcontinuada2.dominios.Jogador;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class Gravar {

    public static String gravarCsvJogador(ListaObj<Jogador> jogador) {
        String arquivo = String.format("%s;%s;%s;%s;%s;%s;%s%n", "ID", "NOME", "VIDA", "ATAQUE", "ID_CAMPANHA", "NOME DA CAMPANHA", "DESCRIÇÃO");

        for (int i = 0; i < jogador.getTamanho(); i++) {
            Jogador j = jogador.getElemento(i);

            arquivo += String.format("%d;%s;%d;%5d;%d;%s;%s%n", j.getId(), j.getNome(), j.getVida(), j.getAtaque(),
                    j.getCampanha().get(0).getId(),
                    j.getCampanha().get(0).getNome(),
                    j.getCampanha().get(0).getDescricao());

        }

        return arquivo;
    }

    public static String gravarTxtJogador(ListaObj<Jogador> jogador) {
        String arquivo = "";

        String header = "00JOGADOR/CAMPANHA";
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += formatter.format(dataDeHoje)+"01\n";
        arquivo += header+"\n";

        for (int i = 0; i < jogador.getTamanho(); i++) {
            Jogador j = jogador.getElemento(i);
//          corpo
            arquivo += String.format("02%04d%-30s%-5d%-5d%04d%-30s%-70s%n", j.getId(), j.getNome(), j.getVida(), j.getAtaque(),
                    j.getCampanha().get(0).getId(),
                    j.getCampanha().get(0).getNome(),
                    j.getCampanha().get(0).getDescricao());
        }
//      trailer
        arquivo += String.format("%n01%07d", jogador.getTamanho());

        return arquivo;
    }
}
