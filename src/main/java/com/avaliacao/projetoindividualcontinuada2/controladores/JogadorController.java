package com.avaliacao.projetoindividualcontinuada2.controladores;

import com.avaliacao.projetoindividualcontinuada2.dominios.Jogador;
import com.avaliacao.projetoindividualcontinuada2.repositorios.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @GetMapping
    public ResponseEntity getTodo() {
        if (repository.count() <= 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPorId(@PathVariable int id){
        Optional<Jogador> jogador = repository.findById(id);
        return ResponseEntity.of(jogador);
    }

    @PostMapping
    public ResponseEntity getCadastrar(@RequestBody Jogador newJogador){
        repository.save(newJogador);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity getExcluir(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity getAtualizar(@PathVariable int id, @RequestBody Jogador jogador) {

        if (repository.existsById(id)) {
            jogador.setId(id);
            repository.save(jogador);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


}
