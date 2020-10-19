package com.avaliacao.projetoindividualcontinuada2.controladores;


import com.avaliacao.projetoindividualcontinuada2.dominios.Jogador;
import com.avaliacao.projetoindividualcontinuada2.gravacao.Gravar;
import com.avaliacao.projetoindividualcontinuada2.gravacao.ListaObj;
import com.avaliacao.projetoindividualcontinuada2.repositorios.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/exportadores")
public class ExportarController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping(value = "/jogadores/csv", produces = {"text/csv"})
    public ResponseEntity exportCsv(){

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment; filename= jogadores.csv");

        if (jogadorRepository.count() <= 0){
            return ResponseEntity.noContent().build();
        }

        ListaObj<Jogador> jogadorListaObj = new ListaObj<>(jogadorRepository.findAll().size());
        for(Jogador j: jogadorRepository.findAll()){
            jogadorListaObj.adiciona(j);
        }

        return new ResponseEntity(
                Gravar.gravarCsvJogador(jogadorListaObj),
                httpHeaders,
                HttpStatus.OK
        );

    }

    @GetMapping(value = "/jogadores/txt", produces = {"text/txt"})
    public ResponseEntity exportTxt() throws IOException {

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment; filename= jogadores.txt");

        if (jogadorRepository.count() <= 0){
            return ResponseEntity.noContent().build();
        }

        ListaObj<Jogador> jogadorListaObj = new ListaObj<>(jogadorRepository.findAll().size());
        for(Jogador j: jogadorRepository.findAll()){
            jogadorListaObj.adiciona(j);
        }

        return new ResponseEntity(
                Gravar.gravarTxtJogador(jogadorListaObj),
                httpHeaders,
                HttpStatus.OK
        );

    }

}
